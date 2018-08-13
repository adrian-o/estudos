import os
import os.path
import shutil

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
            print('Dir: ' + my_dir)
            print('Listing all file logs...')
            list_all_logs(os.path.join(path_dir, my_dir))
        else:
            if is_file_log(my_dir):
                list_file_logs.append(os.path.join(path_dir, my_dir))



def main():
    if not os.path.exists(main_dir):
        print('Erro do caraleo...')
    else:
        list_all_logs(main_dir)

        for file_logs in list_file_logs:
            print('log file: ' + file_logs)

main()