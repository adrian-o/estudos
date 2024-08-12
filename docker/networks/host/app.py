import flask
from flask import request, json, jsonify
import requests
import sqlite3

app = flask.Flask(__name__)

@app.route("/", methods=["GET"])
def index():
  data = requests.get('https://randomuser.me/api')
  return data.json()

@app.route("/inserthost", methods=['POST'])
def inserthost():
  data = requests.get('https://randomuser.me/api').json()
  username = data['results'][0]['name']['first']

  conn = sqlite3.connect('flaskdb.db')
  cur = conn.cursor()
  cur.execute("INSERT INTO usuarios (name) VALUES (?)", (username))
  conn.commit()
  conn.close()

  return username

if __name__ == "__main__":
  app.run(host="0.0.0.0", debug=True, port="5000")