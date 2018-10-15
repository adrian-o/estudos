import os
import os.path
import shutil
from datetime import datetime

main_dir = 'C:\log'
list_file_logs = []

def is_file_log(my_dir):
    last_part = my_dir.split('.')[-1]
    return last_part.isdigit()


def list_all_logs(path_dir):
    list_dir = os.listdir(path_dir)
    
    for my_dir in list_dir:
        verify_dir = os.path.join(path_dir, my_dir)
        
        if os.path.isdir(verify_dir):
            print('dir: ' + my_dir)
            print('listing all file logs...')
            list_all_logs(os.path.join(path_dir, my_dir))
        else:
            if is_file_log(my_dir):
                list_file_logs.append(os.path.join(path_dir, my_dir))


def rename_log_file(log_file):
    # file_parts = log_file.split('.')
    #log_file_new = log_file + '.' + str(date.today())
    log_file_new = log_file + '.' + '{:%Y%m%d-%H%M%S}'.format(datetime.now())
    os.rename(log_file, log_file_new)
     

def execute():
    if not os.path.exists(main_dir):
        print('file path does\'nt exists...')
    else:
        list_all_logs(main_dir)

        for log_file in list_file_logs:
            print('log file: ' + log_file)
            print('renaming...')
            rename_log_file(log_file)
        
        list_file_logs = []