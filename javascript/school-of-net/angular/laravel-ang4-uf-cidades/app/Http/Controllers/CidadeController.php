<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class CidadeController extends Controller
{
    public function getEstados() {
        return \App\Estado::all();
    }

    public function getCidades($estadoId) {
        return \App\Cidade::where('estado_id', $estadoId)->get();
    }
}
