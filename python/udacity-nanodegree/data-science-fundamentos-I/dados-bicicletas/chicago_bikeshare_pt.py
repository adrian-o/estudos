# coding: utf-8

# Começando com os imports
import csv
import matplotlib.pyplot as plt

# Vamos ler os dados como uma lista
print("Lendo o documento...")
with open('chicago.csv', 'r') as file_read:
    reader = csv.DictReader(file_read)
    data_list = list(reader)


print("Ok!")

input("Aperte Enter para continuar...")
# TAREFA 1
# TODO: Imprima as primeiras 20 linhas usando um loop para identificar os dados.
print("\n\nTAREFA 1: Imprimindo as primeiras 20 amostras")

for index in range(20):
    print(data_list[index])

# Vamos mudar o data_list para remover o cabeçalho dele.
# data_list = data_list[1:]

# Nós podemos acessar as features pelo índice
# Por exemplo: sample[6] para imprimir gênero, ou sample[-2]

input("Aperte Enter para continuar...")
# TAREFA 2
# TODO: Imprima o `gênero` das primeiras 20 linhas

print("\nTAREFA 2: Imprimindo o gênero das primeiras 20 amostras")

for i, line in enumerate(data_list[:20],start=1):
    print("Line : {}\tGender: {}".format(i,line['Gender']))

# Ótimo! Nós podemos pegar as linhas(samples) iterando com um for, e as colunas(features) por índices.
# Mas ainda é difícil pegar uma coluna em uma lista. Exemplo: Lista com todos os gêneros

input("Aperte Enter para continuar...")
# TAREFA 3
# TODO: Crie uma função para adicionar as colunas(features) de uma lista em outra lista, na mesma ordem

def column_to_list(data, index):
    """
    Função que retorna uma lista de valores específicos de uma única coluna
    da origem de dados a partir de um índice específico.
    Argumentos:
        param1: Lista de dados originais.
        param2: Índice da coluna dentro da lista.
    Retorna:
        Uma lista com todos os valores da coluna indicada no param2.
    """
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


list_gender = column_to_list(data_list, -2)

# Vamos checar com os gêneros se isso está funcionando (apenas para os primeiros 20)
print("\nTAREFA 3: Imprimindo a lista de gêneros das primeiras 20 amostras")
print(list_gender[:20])

#print(type(list_gender) is list)
#print(len(list_gender) == 1551505)
#print(list_gender[0] == "" and list_gender[1] == "Male")

# ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
assert type(column_to_list(data_list, -2)) is list, "TAREFA 3: Tipo incorreto retornado. Deveria ser uma lista."
assert len(column_to_list(data_list, -2)) == 1551505, "TAREFA 3: Tamanho incorreto retornado."
assert column_to_list(data_list, -2)[0] == "" and column_to_list(data_list, -2)[1] == "Male", "TAREFA 3: A lista não coincide."
# -----------------------------------------------------

input("Aperte Enter para continuar...")
# Agora sabemos como acessar as features, vamos contar quantos Male (Masculinos) e Female (Femininos) o dataset tem
# TAREFA 4
# TODO: Conte cada gênero. Você não deveria usar uma função parTODO isso.
male = 0
female = 0

for gender in list_gender:
    if gender == 'Male':
        male+=1
    elif gender == 'Female':
        female+=1

# Verificando o resultado
print("\nTAREFA 4: Imprimindo quantos masculinos e femininos nós encontramos")
print("Masculinos: ", male, "\nFemininos: ", female)

# ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
assert male == 935854 and female == 298784, "TAREFA 4: A conta não bate."
# -----------------------------------------------------

input("Aperte Enter para continuar...")
# Por que nós não criamos uma função parTODO isso?
# TAREFA 5
# TODO: Crie uma função para contar os gêneros. Retorne uma lista.
# Isso deveria retornar uma lista com [count_male, count_female] (exemplo: [10, 15] significa 10 Masculinos, 15 Femininos)

def count_gender(data_list):
    """
    Função que conta os gêneros da lista da origem de dados.
    Argumentos:
        param1: Lista de dados originais.
    Retorna:
        Uma lista com os valores totais de itens com gênero masculino e femininos no formato
        [8888,9999].
    """
    male = 0
    female = 0

    list_gender = column_to_list(data_list, -2)

    for gender in list_gender:
        if gender == 'Male':
            male+=1
        elif gender == 'Female':
            female+=1

    return [male, female]


print("\nTAREFA 5: Imprimindo o resultado de count_gender")
print(count_gender(data_list))

# ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
assert type(count_gender(data_list)) is list, "TAREFA 5: Tipo incorreto retornado. Deveria retornar uma lista."
assert len(count_gender(data_list)) == 2, "TAREFA 5: Tamanho incorreto retornado."
assert count_gender(data_list)[0] == 935854 and count_gender(data_list)[1] == 298784, "TAREFA 5: Resultado incorreto no retorno!"
# -----------------------------------------------------

input("Aperte Enter para continuar...")
# Agora que nós podemos contar os usuários, qual gênero é mais prevalente?
# TAREFA 6
# TODO: Crie uma função que pegue o gênero mais popular, e retorne este gênero como uma string.
# Esperamos ver "Masculino", "Feminino", ou "Igual" como resposta.

def most_popular_gender(data_list):
    """
    Função que avalia os gêneros da origem de dados e retorna qual dos gêneros
    está mais presente, ou seja, que mais usa as bikes.
    Argumentos:
        param1: Lista de dados originais.
    Retorna:
        Uma String nos valores 'Masculino', 'Feminino' ou 'Igual' dependendo da comparação
        da ocorrência dos gêneros.
    """
    answer = ""
    male,female = count_gender(data_list)

    if male > female:
        answer = 'Masculino'
    elif male < female:
        answer = 'Feminino'
    else:
        answer = 'Igual'

    return answer


print("\nTAREFA 6: Qual é o gênero mais popular na lista?")
print("O gênero mais popular na lista é: ", most_popular_gender(data_list))

# ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
assert type(most_popular_gender(data_list)) is str, "TAREFA 6: Tipo incorreto no retorno. Deveria retornar uma string."
assert most_popular_gender(data_list) == "Masculino", "TAREFA 6: Resultado de retorno incorreto!"
# -----------------------------------------------------

# Se tudo está rodando como esperado, verifique este gráfico!
gender_list = column_to_list(data_list, -2)
types = ["Male", "Female"]
quantity = count_gender(data_list)
y_pos = list(range(len(types)))
plt.bar(y_pos, quantity)
plt.ylabel('Quantidade')
plt.xlabel('Gênero')
plt.xticks(y_pos, types)
plt.title('Quantidade por Gênero')
plt.show(block=True)

input("Aperte Enter para continuar...")
# TAREFA 7
# TODO: Crie um gráfico similar para user_types. Tenha certeza que a legenda está correta.
print("\nTAREFA 7: Verifique o gráfico!")

def columns_values(data, types):
    """
    Função que conta o número de ocorrências de todos os valores de uma determinada coluna
    da origem de dados.
    Argumentos:
        param1: Lista de dados com os valores de uma determinada coluna.
        param2: Lista com os valores distintos presentes nos dados da coluna.
    Retorna:
        Uma lista com os valores totais de cada valor que ocorreu em uma determinada coluna.
    """
    column_list = []
    my_dict = {}

    for i in range(len(types)):
        my_dict[types[i]] = i
        column_list.append(0)

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
plt.show(block=True)

input("Aperte Enter para continuar...")

# TAREFA 8
# TODO: Responda a seguinte questão
male, female = count_gender(data_list)
print("\nTAREFA 8: Por que a condição a seguir é Falsa?")
print("male + female == len(data_list):", male + female == len(data_list))
answer = "Porque existem registros nos dados originais em que o gênero está vazio, ou seja a lista de dados é maior que soma dos masculinos e femininos preenchidos."
print("resposta:", answer)

# ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
assert answer != "Escreva sua resposta aqui.", "TAREFA 8: Escreva sua própria resposta!"
# -----------------------------------------------------

input("Aperte Enter para continuar...")
# Vamos trabalhar com trip_duration (duração da viagem) agora. Não conseguimos tirar alguns valores dele.
# TAREFA 9
# TODO: Ache a duração de viagem Mínima, Máxima, Média, e Mediana.
# Você não deve usar funções prontas parTODO isso, como max() e min().
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
    median_trip = trip_duration_int[int(len(trip_duration_int)/2)+1]


print("\nTAREFA 9: Imprimindo o mínimo, máximo, média, e mediana")
print("Min: ", min_trip, "Max: ", max_trip, "Média: ", mean_trip, "Mediana: ", median_trip)

# ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
assert round(min_trip) == 60, "TAREFA 9: min_trip com resultado errado!"
assert round(max_trip) == 86338, "TAREFA 9: max_trip com resultado errado!"
assert round(mean_trip) == 940, "TAREFA 9: mean_trip com resultado errado!"
assert round(median_trip) == 670, "TAREFA 9: median_trip com resultado errado!"
# -----------------------------------------------------

input("Aperte Enter para continuar...")

# TAREFA 10
# Gênero é fácil porque nós temos apenas algumas opções. E quanto a start_stations? Quantas opções ele tem?
# TODO: Verifique quantos tipos de start_stations nós temos, usando set()
ss_types = set(column_to_list(data_list, 3))

print("\nTAREFA 10: Imprimindo as start stations:")
print(len(ss_types))
print(ss_types)

# ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
assert len(ss_types) == 582, "TAREFA 10: Comprimento errado de start stations."
# -----------------------------------------------------

input("Aperte Enter para continuar...")

# TAREFA 11
# Volte e tenha certeza que você documenteou suas funções. Explique os parâmetros de entrada, a saída, e o que a função faz. Exemplo:
# def new_function(param1: int, param2: str) -> list:
#      """
#      Função de exemplo com anotações.
#      Argumentos:
#          param1: O primeiro parâmetro.
#          param2: O segundo parâmetro.
#      Retorna:
#          Uma lista de valores x.

#      """

input("Aperte Enter para continuar...")
# TAREFA 12 - Desafio! (Opcional)
# TODO: Crie uma função para contar tipos de usuários, sem definir os tipos
# para que nós possamos usar essa função com outra categoria de dados.
print("Você vai encarar o desafio? (yes ou no)")
answer = "yes"

def count_items(column_list):
    """
    Função que conta os tipos de uma coluna passada como uma lista.
    Argumentos:
        param1: Lista com os valores de uma determinada coluna.
    Retorna:
        Uma lista de valores distindos da coluna; Uma lista de totais 
        que esses items se repetem na coluna.
    """
    item_types = list(set(column_list))
    count_items = []
    my_dict = {}

    for i in range(len(item_types)):
        my_dict[item_types[i]] = i
        count_items.append(0)

    for item in column_list:
        count_items[my_dict[item]] += 1

    return item_types, count_items


if answer == "yes":
    # ------------ NÃO MUDE NENHUM CÓDIGO AQUI ------------
    column_list = column_to_list(data_list, -2)
    types, counts = count_items(column_list)
    print("\nTAREFA 11: Imprimindo resultados para count_items()")
    print("Tipos:", types, "Counts:", counts)
    assert len(types) == 3, "TAREFA 11: Há 3 tipos de gênero!"
    assert sum(counts) == 1551505, "TAREFA 11: Resultado de retorno incorreto!"
    # -----------------------------------------------------
