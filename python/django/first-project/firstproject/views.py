from django.http import HttpResponse

def hello(request):
    return HttpResponse('Olá mundo')

def teste_int(request, par):
    return HttpResponse('O valor do parâmetro é ' + str(par))