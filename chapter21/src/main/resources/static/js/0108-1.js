class NintendoGame {
  static #uniqueId = 3;
  #gameList = [{}];
  setList(){
      let self = this;
      $.ajax({
          url: "/api/get-all-games",  // your backend URL to fetch all games
          type: "POST",
          dataType: "json",
          contentType: "application/json",
          data: JSON.stringify({})
      })
          .done(function(dataList) {
              self.#gameList = dataList;
              self.printList();
          })
          .fail(function(jqXHR, textStatus, errorThrown) {
              console.log("게임 목록 가져오기 실패:", textStatus);
              alert("게임 목록을 불러오는데 실패했습니다.");
          });
  }

  printList() {
    $("#listDataBlock").empty();
    $("#listDataBlock").append(`
      <div class="listDataRow">
        <div class="listItem">
          <div class="itemData text-wrapper onlyForSaveId">0</div>
        </div>
        <div class="listItem">
          <div class="itemData text-wrapper">장르</div>
        </div>
        <div class="listItem">
          <div class="itemData text-wrapper">등급</div>
        </div>
        <div class="listItem">
          <div class="itemData text-wrapper">제목</div>
        </div>
      </div>
    `)
    this.#gameList.forEach((item) => {
      $("#listDataBlock").append(this.printRow(item));
    });
  }

  printGenre(genre) {
    switch (genre) {
      case "A":
        return "액션";
      case "S":
        return "스포츠";
      case "R":
        return "RPG";
    }
    return "-";
  }

  printGrade(grade) {
    switch (grade) {
      case "ALL":
        return "전체이용";
      case "18":
        return "18세이상";
      case "13":
        return "13세이상";
    }
    return "-";
  }

  printRow(item) {
    let html = `
<div class="listDataRow">
  <div class="listItem">
    <div class="itemData text-wrapper onlyForSaveId">${item.id}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${this.printGenre(item.genre)}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${this.printGrade(item.grade)}</div>
  </div>
  <div class="listItem">
    <div class="itemData text-wrapper">${item.name}</div>
  </div>
</div>`;
    return html;
  }

  checkInputDataIsError() {
    // 사용자 입력데이터 검증한다.
    // 입력데이터가 올바르면 true 리턴
    // 아니면 false 리턴
    if ($("#name").val()==='') {
      alert(`게임이름을 입력하세요`);
      $("#name").focus();
      return true;
    }
    if ($("#price").val() < 0) {
      alert(`가격이 0이하 입니다.`);
      $("#clss").focus();
      return true;
    }
    if ($("#imgUrl").val().length < 10) {
      alert(`주소를 제대로`);
      $("#name").focus();
      return true;
    }
    return false;
  }

  createGameData(forAdd) {
    return {
        id: forAdd == "forAdd" ? NintendoGame.#uniqueId++ : $("#id").val()
        , name: $("#name").val()
        , genre: $("#genre").val()
        , grade: $("#grade").val()
        , price: $("#price").val()
        , imgUrl: $("#imgUrl").val()
    }
  }

  addGame() {
    // 사용자 입력 데이터가 유효한지 검증해야 한다. 유효하지 않으면 경고창 띄우고 리턴;
    if(this.checkInputDataIsError())
      return;
    // 입력데이터는 JS 객체로 만든다. let JS객체 = {id:고유번호, name:$("#name").val(), genre:"S", grade:"ALL", price:금액, imgUrl:"http://..."};
    let newGame = this.createGameData("forAdd");
    // gameList 배열에 JS객체 를 추가한다. this.#gameList.push(JS객체);
    // this.#gameList.push(newGame);
    // gameList 배열정보를 게임목록 화면에 출력한다. this.printList();
    this.insertData(newGame);
  }

  updateGame() {
    // 사용자 입력 데이터가 유효한지 검증해야 한다. 유효하지 않으면 경고창 띄우고 리턴;
    if(this.checkInputDataIsError())
      return;
    // 입력데이터는 JS 객체로 만든다. let JS객체 = {id:고유번호, name:$("#name").val(), genre:"S", grade:"ALL", price:금액, imgUrl:"http://..."};
    let modifyGame = this.createGameData("");
    // gameList 배열에서 JS객체.id 번호랑 같은 원소를 찾는다. let 찾는객체 = this.#gameList.find(() => {});
    // JS객체를 찾는객체로 바꿔치기 한다.
    // let findIndex = this.#gameList.findIndex((item) => {
    //   return item.id * 1 === modifyGame.id * 1; //여기서 input id="id"가 일치하는지 찾기 때문에 0이 있어도 이상한 값 추가 안되고 리턴
    // })
    // if (findIndex === -1)
    //   return;
    // else
    //   this.#gameList = this.#gameList.with(findIndex, modifyGame);
    // // gameList 배열정보를 게임목록 화면에 출력한다. this.printList();
    // $("#showImage").attr("src", modifyGame.imgUrl);
    this.updateData(modifyGame)
  }

  deleteGame() {
    // 사용자 입력 데이터가 유효한지 검증해야 한다. 유효하지 않으면 경고창 띄우고 리턴;
    if(this.checkInputDataIsError())
      return;
    // gameList 배열에서 기존의 id 번호랑 같은 원소를 찾는다.
    // let findIndex = this.#gameList.findIndex((item) => {
    //   return item.id * 1 === $("#id").val() * 1; //여기서 input id="id"가 일치하는지 찾기 때문에 0이 있어도 이상한 값 추가 안되고 리턴
    // })
    // if (findIndex === -1)
    //   return;
    // else
    //   // 찾는객체를 gameList 배열에서 삭제한다.
    //   this.#gameList.splice(findIndex, 1);
    // // gameList 배열정보를 게임목록 화면에 출력한다. this.printList();
    // $("#showImage").attr("src", "../bin.png");
    let deletedGame = this.createGameData("");
    this.deleteData(deletedGame.id);
  }
  insertData(newGame) {
      let self = this;
    // 1. 화면에서는 JSON 데이터를 서버 URL 과 Method POST 로 전송하는 Jquery AJAX 를 구현해야 한다.
    // 2. 웹서버에서는 서버 URL 와 Method POST 와 JSON 데이터를 받아들이는 컨트롤러를 구현해야 한다.
    // 3. 웹서버 컨트롤러는 DataBase Service 에 inset 하는 동작을 실행해야 한다.
    // 4. Data Service 는 insert 하는 mybatis insert 메소드를 실행해야 한다.
    // 5. mybatis insert 메소드는 SQL INSERT query 를 데이터베이스연결한 컨넥션풀에서 실행해야 한다.
    // 6. 실행할 결과를 역순으로 화면까지 리턴해야 한다.
	$.ajax({
	    url: "/api/insert-data" // 요청 URL
	    , type: "POST"          // 전송 방식 (GET, POST 등)
	    , dataType: "json"      // 응답 데이터 타입
	    , data: JSON.stringify(newGame)
	    , contentType: "application/json"
	})
	.done(function(data, textStatus, jqXHR) {
	    // 요청 성공 시 실행
	    console.log("성공:", data);
//	    $("#result").text(data.message);
        self.clearInputBox();
        self.setList();
	})
	.fail(function(jqXHR, textStatus, errorThrown) {
	    // 요청 실패 시 실행
	    console.error("실패:", textStatus);
	})
	.always(function() {
	    // 성공/실패 관계없이 항상 실행
	    console.log("요청 완료");
	});
  }
  updateData(gameData){
      let self = this;
      $.ajax({
          url: "/api/update-data" // 요청 URL
          , type: "POST"          // 전송 방식 (GET, POST 등)
          , dataType: "json"      // 응답 데이터 타입
          , data: JSON.stringify(gameData)
          , contentType: "application/json"
      }).done(function(data, textStatus, jqXHR) {
          // 요청 성공 시 실행
          alert("성공:", data);
          //$("#result").text(data.message);
          self.setList();
          self.clearInputBox();
      }).fail(function(jqXHR, textStatus, errorThrown) {
          // 요청 실패 시 실행
          alert("실패:", textStatus);
      }).always(function() {
          // 성공/실패 관계없이 항상 실행
          // console.log("요청 완료");
      });
  }
  deleteData(gameId) {
      let self = this;
      $.ajax({
          url: "/api/delete-data"
          , type: "POST"
          , dataType: "json"
          , data: JSON.stringify({id: gameId})
          , contentType: "application/json"
      })
      .done(function(data, textStatus, jqXHR) {
          // 요청 성공 시 실행
          alert("성공:", data);
          //$("#result").text(data.message);
          self.setList();
          self.clearInputBox();
      })
      .fail(function(jqXHR, textStatus, errorThrown) {
          // 요청 실패 시 실행
          alert("실패:", textStatus);
      })
      .always(function() {
          // 성공/실패 관계없이 항상 실행
          // console.log("요청 완료");
      });
  }

  printOneGame(id) {
    // 화면의 id 값으로 gameList배열에서 찾는다. let id값 = $("#id").val();, let 찾은원소 = this.#gameList.find(() => {});
    let findGame = this.#gameList.find((game) => {
      return game.id * 1 === id * 1;
    });
    if (findGame === undefined){
    }
    else
      this.setData2InputBox(findGame);
  }

  setData2InputBox(game) {
      $("#id").val(game.id);
      $("#name").val(game.name);
      $("#genre").val(game.genre);
      $("#grade").val(game.grade);
      $("#price").val(game.price);
      $("#imgUrl").val(game.imgUrl);
      $("#showImage").attr("src", game.imgUrl);
  }
  clearInputBox() {
      $("#id").val(0);
      $("#name").val("");
      $("#genre").prop("selectedIndex", 0);
      $("#grade").prop("selectedIndex", 0);
      $("#price").val("");
      $("#imgUrl").val("");
  }
}

$(() => {
  // jquery 실행
  let nint = new NintendoGame();
  nint.setList();

  $("#btnAdd").click((e) => {
    nint.addGame();
  });

  $(document).on("click", "#btnUpt", (e) => {
    nint.updateGame();
  });

  $(document).on("click", "#btnDel", (e) => {
    nint.deleteGame();
  });

  $(document).on(`click`, ".listDataRow", function (e) {
    nint.printOneGame(
      $(e.currentTarget)
        .children()
        .first()
        .text()
    );
  });
});