package com.mjc813.game;
import java.util.Scanner;
import com.mjc813.sec.hankook.B;

public class Pane implements ButtonEvent {
    private Area inputArea;
    private Area listArea;

    Label[] labels;

    Label ins;
    Label upd;
    Label del;

    Image img;

    Input inputGameTitle;
    InputSelect inputGenre;
    InputSelect inputRate;
    Input inputPrice;
    Input inputUrl;

    Block buttons;

    Block description;
    public Pane(){
        inputArea = new Area(600,400);
        labels = new Label[5];
        labels[0] = new Label("게임제목");
        labels[1] = new Label("장르");
        labels[2] = new Label("등급");
        labels[3] = new Label("가격");
        labels[4] = new Label("이미지주소");

        ins = new Label("추가");
        upd = new Label("수정");
        del = new Label("삭제");

        img = new Image("아무 url");

        inputGameTitle = new Input();

        inputGenre = new InputSelectGanre(); //다형성
        inputRate = new InputSelectRate(); //다형성

        inputPrice = new Input();
        inputUrl = new Input("아무 이미지 주소");

        Block[] blocks = new Block[5];
        blocks[0] = new Block();
        blocks[1] = new Block();
        blocks[2] = new Block();
        blocks[3] = new Block();
        blocks[4] = new Block();

        Block imgBlock = new Block();

        for(int i = 0; i < blocks.length;i++){
            blocks[i].add(labels[i]);
        }
        blocks[0].add(inputGameTitle);
        blocks[1].add(inputGenre);
        blocks[2].add(inputRate);
        blocks[3].add(inputPrice);
        blocks[4].add(inputUrl);

        imgBlock.add(img);

        for(int i = 0; i < blocks.length;i++){
            inputArea.add(blocks[i]);
        }

        buttons = new Block();
        buttons.add(ins);
        buttons.add(upd);
        buttons.add(del);

        listArea = new Area(400,400);

        description = new Block();

        Label g = new Label("장르");
        Label r = new Label("등급");
        Label t = new Label("제목");

        description.add(g);
        description.add(r);
        description.add(t);

        listArea.add(description);
    }

    @Override
    public void buttonEvent() {
        Scanner sc = new Scanner(System.in);
        while (true){
            String event = sc.next();
            if(event.equals(ins.getText())){
                System.out.print("장르: ");
                String s = sc.next();
                inputGenre.setSelect(s); //다형성
                Label addGenre = new Label(inputGenre.getSelectedItem());

                System.out.print("등급: ");
                s = sc.next();
                inputRate.setSelect(s); //다형성
                Label addRate = new Label(inputRate.getSelectedItem());

                System.out.print("제목: ");
                s = sc.next();
                inputGameTitle.setText(s);
                Label addTitle = new Label(inputGameTitle.getText());

                Block addBlock = new Block();
                addBlock.add(addGenre);
                addBlock.add(addRate);
                addBlock.add(addTitle);

                listArea.add(addBlock);
            }
            else if(event.equals(upd.getText())){
                listArea.showBlockId();
                System.out.print("id 선택: ");
                int index = sc.nextInt();

                for(int i = 0; i < listArea.getSize(); i++){
                    if(index == listArea.getBlocks()[i].getId()){
                        System.out.print("장르: ");
                        String s = sc.next();
                        changeLabel(listArea.getBlocks()[i].getLabels()[0],s);

                        System.out.print("등급: ");
                        s = sc.next();
                        changeLabel(listArea.getBlocks()[i].getLabels()[1],s);

                        System.out.print("제목: ");
                        s = sc.next();
                        changeLabel(listArea.getBlocks()[i].getLabels()[2],s);
                    }
                    else return;
                }
            }
            else if(event.equals(del.getText())){
                listArea.showBlockId();
                System.out.print("id 선택: ");
                int index = sc.nextInt();

                for(int i = 0; i < listArea.getSize(); i++){
                    if(index == listArea.getBlocks()[i].getId()){
                        listArea.del(index);
                    }
                    else return;
                }
            }
        }
    }

    public void changeLabel(Label label, String s){
        label.setText(s);
    }
}
