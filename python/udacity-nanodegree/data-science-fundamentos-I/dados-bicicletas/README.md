Os conjuntos de dados

Os dados para os primeiros seis meses de 2017 são fornecidos. O arquivo de dados contêm seis (6) colunas principais:

Horário de início (ex., 2017-01-01 00:07:57)

Horário de término (ex., 2017-01-01 00:20:53)

Duração da viagem (em segundos, ex., 776)

Estação inicial (ex., Broadway & Barry Avenue)

Estação final (ex., Sedgwick St & do North Ave)

Tipo de usuário (assinante ou cliente)

Gênero do usuário

Ano de nascimento do usuário


As perguntas

Você vai escrever um código para completar as seguintes tarefas sobre os dados de compartilhamento de bicicletas:

Tarefa 1: Mostre as 20 primeiras amostras (linhas) da base de dados

Tarefa 2: Mostre o gênero (coluna) das 20 primeiras amostras

Tarefa 3: Cria uma função para pegar colunas como lista

Tarefa 4: Conte quantas pessoas de cada gênero

Tarefa 5: Crie uma função para contar os gêneros

Tarefa 6: Mostre o gênero mais popular

Tarefa 7: Mostre um gráfico usando os dados anteriores

Tarefa 8: Responda o motivo do número de homens e mulheres não bater com a quantidade de amostras

Tarefa 9: Encontre o valor mínimo, máximo, média e mediana da duração de viagens

Tarefa 10: Mostre todas as estações da base de dados

Tarefa 11: Crie uma função que conte a ocorrência de qualquer coluna (opcional)


DICAS:

O módulo csv é essencial para a conclusão deste projeto. Um ponto para prestar atenção: esses arquivos CSV de compartilhamento de bicicletas são 
bastante grandes, então iterá-los vai ser caro computacionalmente. Temos duas estratégias para mitigar isso:

Não tente abrir o arquivo CSV com um editor de texto. Isso pode travar seu computador.
Carregue cada arquivo CSV em uma estrutura de dados uma vez no início do script. O código está pronto para ler o arquivo como uma lista de listas 
(e tudo bem usá-lo assim) Mas você pode trabalhar com outras formas. Dica: Trabalhar com um DictReader, de lista de dicionários, pode ser uma boa 
opção (veja esse Stack Overflow post. Teste regularmente seu código enquanto você o desenvolve. A função print é sua amiga.