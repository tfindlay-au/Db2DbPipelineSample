import os
import random

import psycopg2

moods = ['happy', 'sad']
rows_to_generate = int(os.environ['GEN_ROWS'])
pg_host = os.environ['PG_HOST']
pg_db = os.environ['PG_DATABASE']
pg_user = os.environ['PG_USER']
pg_password = os.environ['PGPASSWORD']

conn = psycopg2.connect(f"host={pg_host} dbname={pg_db} user={pg_user} password={pg_password}")
print('Connected to DB')

cur = conn.cursor()
cur.execute("""
CREATE TABLE IF NOT EXISTS mood_table (
    age INTEGER NOT NULL,
    mood VARCHAR(255) NOT NULL
)
""")
conn.commit()

for _ in range(rows_to_generate):
    age = random.randint(13,99)
    mood = random.choice(moods)
    cur.execute(f"INSERT INTO mood_table VALUES ({age}, '{mood}')")
conn.commit()

print('Insert complete')
cur.close()