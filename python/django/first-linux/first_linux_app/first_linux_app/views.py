from django.http import HttpResponse
from django.shortcuts import render

def hello(request):
    return render(request, 'index.html')

def articles(request, year):
    return HttpResponse('Articles in ' + str(year))

def ler_do_banco(nome):
    dic_nome = [
        {'nome':'Adriano','idade':35},
        {'nome':'Marcia','idade':29},
        {'nome':'Kaylane','idade':10}
    ]

    for pessoa in dic_nome:
        if nome == pessoa['nome']:
            return pessoa

    return {'nome':'Pessoa não encontrada','idade':0}

def pessoa(request, nome):
    result = ler_do_banco(nome)['idade']
    return render(request,'pessoa.html', {'idade':result})