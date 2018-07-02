# coding: utf-8

# Começando com os imports
import csv
import matplotlib.pyplot as plt

# Vamos ler os dados como uma lista
print("Lendo o documento...")
with open('chicago.csv', 'r') as file_read:
    data_list = [{k: v for k, v in row.items()}
        for row in csv.DictReader(file_read, skipinitialspace=True)]
print("Ok!")

# TAREFA 1
# TODO: Imprima as primeiras 20 linhas usando um loop para identificar os dados.
print("\n\nTAREFA 1: Imprimindo as primeiras 20 amostras")

#for index in range(20):
#    print(data_list[index])

print("\nTAREFA 2: Imprimindo o gênero das primeiras 20 amostras")

#for index in range(20):
#    print(data_list[index]['Gender'])

# Ótimo! Nós podemos pegar as linhas(samples) iterando com um for, e as colunas(features) por índices.
# Mas ainda é difícil pegar uma coluna em uma lista. Exemplo: Lista com todos os gêneros



# {'Start Time', 'End Time', 'Trip Duration', 'Start Station', 'End Station', 'User Type', 'Gender', 'Birth Year'}

# TAREFA 3
# TODO: Crie uma função para adicionar as colunas(features) de uma lista em outra lista, na mesma ordem
def column_to_list(data, index):
    column_list = []
    my_dict_keys = list(data[0].keys())
    my_dict = {}

    for i in range(len(my_dict_keys)):
        my_dict[my_dict_keys[i]] = i
        column_list.append([])

    for internal_list in data:
        for k, v in my_dict.items():
            column_list[v].append(internal_list[k])
    
    return column_list[index]

# Vamos checar com os gêneros se isso está funcionando (apenas para os primeiros 20)
print("\nTAREFA 3: Imprimindo a lista de gêneros das primeiras 20 amostras")
print(column_to_list(data_list, -2)[:20])
