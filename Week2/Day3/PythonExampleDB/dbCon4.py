import mysql.connector as sql


class Connect:
    @staticmethod
    def connection():
        """connects and returns connection and cursor"""

        try:
            connection = sql.connect(host="localhost",
                                     user="root",
                                     password="p4ssword",
                                     db="test"
                                     )

            cursor = connection.cursor()

            return [connection, cursor]

        except sql.Error as e:
            print(e)


class Queries:

    # parameterized constructor
    def __init__(self, connection, cursor):
        self.curs = cursor
        self.conn = connection

    def query1(self):
        """inserts and then runs Select query and prints table"""
        self.curs.execute("INSERT INTO users VALUES(11, 'start', '2001-03-09');")
        self.conn.commit()

        select1 = "SELECT * FROM users"
        self.curs.execute(select1)

        # Fetch all the records and use a for loop to print them one line at a time
        result = self.curs.fetchall()
        for i in result:
            print(i)


connectList = Connect.connection()
obj = Queries(connectList[0], connectList[1])
obj.query1()
