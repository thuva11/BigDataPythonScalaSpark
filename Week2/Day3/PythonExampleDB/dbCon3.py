import mysql.connector as sql


def insert():
    """inserts and then runs Select query and prints table"""

    try:
        connection = sql.connect(host="localhost",
                                 user="root",
                                 password="p4ssword",
                                 db="test"
                                 )

        cursor = connection.cursor()

        cursor.execute("INSERT INTO users VALUES(11, 'start', '2001-03-09');")
        connection.commit()

        select1 = "SELECT * FROM users"
        cursor.execute(select1)

        # Fetch all the records and use a for loop to print them one line at a time
        result = cursor.fetchall()
        for i in result:
            print(i)

    except sql.Error as e:
        print(e)

    finally:
        connection.close()


insert()
