<?php

use Illuminate\Database\Seeder;

class CidadesDistritoFederalSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('cidades')->insert([
        	['cidade' => 'Brasília', 'estado_id' => 7]
        ]);
    }
}
