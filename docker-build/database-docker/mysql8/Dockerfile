# 사용할 MySQL 공식 이미지 버전 지정
FROM mysql:8.4.5

# 개발 환경에 맞게 언어셋 및 타임존 설정 (선택 사항)
ENV TZ=Asia/Seoul

# 로컬의 init.sql 파일을 컨테이너 내부의 자동 실행 디렉토리로 복사
COPY ./init.sql /docker-entrypoint-initdb.d/init.sql

# 보안 및 권한 문제 방지를 위해 실행 권한 부여 (필요 시)
RUN chmod 644 /docker-entrypoint-initdb.d/init.sql

ENTRYPOINT ["docker-entrypoint.sh", "mysqld"]