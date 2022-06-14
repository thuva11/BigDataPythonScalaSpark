import pymysql

connection = pymysql.connect(host='localhost',
                             user='root',
                             password='p4ssword',
                             db='test'
                             )

cursor = connection.cursor()

sql = "SELECT * FROM users"
cursor.execute(sql)

# Fetch all the records and use a for loop to print them one line at a time
result = cursor.fetchall()
for i in result:
    print(i)

cursor.execute("INSERT INTO users VALUES(8, 'start', '2001-03-09');")
connection.commit()

connection.close()