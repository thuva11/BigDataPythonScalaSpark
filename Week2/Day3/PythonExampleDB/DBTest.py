from mysql.connector import (connection)

cnx = connection.MySQLConnection(user='root', password='p4ssword',
                                 host='127.0.0.1',
                                 database='test')

cursor = cnx.cursor()
query = ("SELECT * FROM users")

cursor.execute(query)
for x in cursor:
    print(x)

print("hello")

cursor.execute(query)
y=[x for x in cursor]

print(y)

cnx.close()