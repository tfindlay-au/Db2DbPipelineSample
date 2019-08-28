FROM python:3.7-alpine
RUN apk update && apk add postgresql-dev gcc python3-dev musl-dev
RUN pip install psycopg2

WORKDIR /home
CMD python data_gen.py