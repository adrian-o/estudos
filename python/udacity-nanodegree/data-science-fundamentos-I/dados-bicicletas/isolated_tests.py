# coding: utf-8

import statistics

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
#print("\n\nTAREFA 1: Imprimindo as primeiras 20 amostras")

#for index in range(2000):
#    print(data_list[index])

#print("\nTAREFA 2: Imprimindo o gênero das primeiras 20 amostras")

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
"""
list_gender = column_to_list(data_list, -2)

# Vamos checar com os gêneros se isso está funcionando (apenas para os primeiros 20)
print("\nTAREFA 3: Imprimindo a lista de gêneros das primeiras 20 amostras")
print(list_gender[:20])

def count_gender(data_list):
    male = 0
    female = 0

    list_gender = column_to_list(data_list, -2)

    for gender in list_gender:
        if gender == 'Male':
            male+=1
        elif gender == 'Female':
            female+=1

    return [male, female]

# TAREFA 7
# TODO: Crie um gráfico similar para user_types. Tenha certeza que a legenda está correta.
print("\nTAREFA 7: Verifique o gráfico!")

def columns_values(data, types):
    column_list = []
    my_dict = {}

    for i in range(len(types)):
        my_dict[types[i]] = i
        column_list.append(my_dict[types[i]])

    for item in data:
        column_list[my_dict[item]] += 1
 
    return column_list


user_type_list = column_to_list(data_list, -3)
types = list(set(user_type_list))
quantity = columns_values(user_type_list, types)
y_pos = list(range(len(types)))
plt.bar(y_pos, quantity)
plt.ylabel('Quantidade')
plt.xlabel('Tipo de usuario')
plt.xticks(y_pos, types)
plt.title('Quantidade por tipo de usuario')
plt.show(block=True)"""
"""
trip_duration_list = column_to_list(data_list, 2)
min_trip = 0.
max_trip = 0.
mean_trip = 0.
median_trip = 0.

for val in trip_duration_list:
    int_val = int(val)
    mean_trip += int_val
    if min_trip == 0 or int_val < min_trip:
        min_trip = int_val
    if max_trip < int_val:
        max_trip = int_val     

mean_trip = round(mean_trip / len(trip_duration_list))

trip_duration_int = []

for item in trip_duration_list:
    trip_duration_int.append(int(item))

trip_duration_int.sort()

if len(trip_duration_int)%2 == 0:
    middle_one = trip_duration_int[len(trip_duration_int)/2]
    middle_two = trip_duration_int[(len(trip_duration_int)/2)-1]
    median_trip = (middle_one + middle_two) / 2
else:
    #median_trip = statistics.median(trip_duration_int)
    median_trip = trip_duration_int[int(len(trip_duration_int)/2)+1]


print("\nTAREFA 9: Imprimindo o mínimo, máximo, média, e mediana")
print("Min: ", min_trip, "Max: ", max_trip, "Média: ", mean_trip, "Mediana: ", median_trip)

# TAREFA 10
# Gênero é fácil porque nós temos apenas algumas opções. E quanto a start_stations? Quantas opções ele tem?
# TODO: Verifique quantos tipos de start_stations nós temos, usando set()
ss_types = set(column_to_list(data_list, 3))

print("\nTAREFA 10: Imprimindo as start stations:")
print(len(ss_types))
print(ss_types)
"""

def count_items(column_list):
    item_types = list(set(column_list))
    count_items = []
    my_dict = {}

    for i in range(len(item_types)):
        my_dict[item_types[i]] = i
        count_items.append(0)

    for item in column_list:
        count_items[my_dict[item]] += 1

    return item_types, count_items

column_list = column_to_list(data_list, -2)
print(len(column_list))
types, counts = count_items(column_list)
print("\nTAREFA 11: Imprimindo resultados para count_items()")
print("Tipos:", types, "Counts:", counts)
assert len(types) == 3, "TAREFA 11: Há 3 tipos de gênero!"
assert sum(counts) == 1551505, "TAREFA 11: Resultado de retorno incorreto!"