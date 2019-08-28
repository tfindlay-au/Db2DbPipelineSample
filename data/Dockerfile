FROM python:3.7-alpine
RUN apk update && apk add postgresql-dev gcc python3-dev musl-dev postgresql-client
RUN pip install psycopg2

WORKDIR /home
CMD ./wait_for_postgres.sh && python data_gen.py