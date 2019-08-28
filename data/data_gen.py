import os
import random

import psycopg2

moods = ['happy', 'sad']
rows_to_generate = int(os.environ['GEN_ROWS'])

conn = psycopg2.connect("host=postgresdb dbname=postgres user=postgres password=mysecretpassword")
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
    cur.execute("INSERT INTO mood_table VALUES (%s, %s)", age, mood)
conn.commit()

print('Insert complete')
cur.close()