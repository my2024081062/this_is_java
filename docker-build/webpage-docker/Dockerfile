# docker image file을 만드는 형식 => Dockerfile 파일명
# docker image는 레이어 단위로 구성
# 가장 중요하고 가장 먼저 선언할 것 : 어떤 이미지를 가지고 시작할 것인지 결정
FROM nginx:alpine

# 이미지 만들 때 파일을 복사해라 (이미지운영체제디렉토리 )
COPY ./webpage /usr/share/nginx/html 