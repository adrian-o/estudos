import schedule
import time
import rename_logs

def job():
    rename_logs.execute()

schedule.every().minute.do(job)

while True:
    schedule.run_pending()
    time.sleep(1)