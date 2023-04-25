package Presentacion.Controller;

public class Events {
	
	public static final int VENTANA_PRINCIPAL = 1;
	public static final int VENTANA_PRINCIPAL_INSTANCE = 2;
	//Empleado
	public static final int EMPLEADO_VISTA = 100;
	public static final int EMPLEADO_NUEVA_VISTA = 101;
	
	public static final int EMPLEADO_CREAR_VISTA = 110;
	public static final int EMPLEADO_CREAR = 111;
	public static final int EMPLEADO_CREAR_REPEATED = 112;
	public static final int EMPLEADO_CREAR_WRONG_PARAMETERS = 113;
	public static final int EMPLEADO_CREAR_SUCCESS = 114;
	public static final int EMPLEADO_CREAR_WRONG_NUMBER = 115;
	public static final int EMPLEADO_CREAR_WRONG_MAIL = 116;
	public static final int EMPLEADO_CREAR_NO_DEPARTAMENT = 117;
	public static final int EMPLEADO_CREAR_DEPARTAMENT_INACTIVE = 118;
	
	public static final int EMPLEADO_MODIFICAR = 120; 
	public static final int EMPLEADO_MODIFICAR_VISTA = 121;
	public static final int EMPLEADO_MODIFICAR_NOTFOUND= 122;
	public static final int EMPLEADO_MODIFICAR_WRONG_PARAMETERS = 123;
	public static final int EMPLEADO_MODIFICAR_SUCCESS = 124;
	public static final int EMPLEADO_MODIFICAR_WRONG_NUMBER = 125;
	public static final int EMPLEADO_MODIFICAR_WRONG_MAIL = 126;
	public static final int EMPLEADO_MODIFICAR_NO_DEPARTAMENT = 127;
	public static final int EMPLEADO_MODIFICAR_DEPARTAMENT_INACTIVE = 128;
	
	public static final int EMPLEADO_ELIMINAR = 130;
	public static final int EMPLEADO_ELIMINAR_VISTA = 131;
	public static final int EMPLEADO_ELIMINAR_ERROR = 132;
	public static final int EMPLEADO_ELIMINAR_NOTFOUND = 133;
	public static final int EMPLEADO_ELIMINAR_SUCCESS = 134;
	
	public static final int EMPLEADO_MOSTRAR_UNO = 140;
	public static final int EMPLEADO_MOSTRAR_UNO_VISTA = 141;
	public static final int EMPLEADO_MOSTRAR_UNO_SI_ID = 143;
	public static final int EMPLEADO_MOSTRAR_UNO_NO_ID = 142;
	
	public static final int EMPLEADO_MOSTRAR_TODOS = 150;
	public static final int EMPLEADO_MOSTRAR_TODOS_VISTA = 151;
	public static final int EMPLEADO_MOSTRAR_TODOS_SUCCESS = 152;
	public static final int EMPLEADO_MOSTRAR_TODOS_ERROR = 153;
	
	public static final int EMPLEADO_MOSTRAR_POR_DEPARTAMENTO = 160;
	public static final int EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_VISTA = 161;
	public static final int EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_ID = 162;
	public static final int EMPLEADO_MOSTRAR_POR_DEPARTAMENTO_NOID= 163;
	
	public static final int EMPLEADO_VINCULAR = 164;
	public static final int EMPLEADO_VINCULAR_VISTA = 165;
	public static final int EMPLEADO_VINCULAR_NOID = 166;
	public static final int EMPLEADO_VINCULAR_TAREA_NO_ACTIVA = 167;
	public static final int EMPLEADO_VINCULAR_EMPLEADO_NO_ACTIVO = 168;
	public static final int EMPLEADO_VINCULAR_SUCCESS = 169;

	public static final int EMPLEADO_DESVINCULAR = 170;
	public static final int EMPLEADO_DESVINCULAR_VISTA = 171;
	public static final int EMPLEADO_DESVINCULAR_NOID = 172;
	public static final int EMPLEADO_DESVINCULAR_TAREA_NO_ACTIVA = 173;
	public static final int EMPLEADO_DESVINCULAR_EMPLEADO_NO_ACTIVO = 174;
	public static final int EMPLEADO_DESVINCULAR_SUCCESS = 175;

	public static final int EMPLEADO_MOSTRAR_EMPYTAR = 176;
	public static final int EMPLEADO_MOSTRAR_EMPYTAR_VISTA = 177;
	public static final int EMPLEADO_MOSTRAR_EMPYTAR_ID = 178;
	public static final int EMPLEADO_MOSTRAR_EMPYTAR_NOID = 179;
	
	public static final int EMPLEADO_MOSTRAR_POR_TAREA = 180;
	public static final int EMPLEADO_MOSTRAR_POR_TAREA_VISTA = 181;
	public static final int EMPLEADO_MOSTRAR_POR_TAREA_ID = 182;
	public static final int EMPLEADO_MOSTRAR_POR_TAREA_NOID = 183;
	
	public static final int EMPLEADO_MOSTRAR_POR_EMPLEADO = 190;
	public static final int EMPLEADO_MOSTRAR_POR_EMPLEADO_VISTA = 191;
	public static final int EMPLEADO_MOSTRAR_POR_EMPLEADO_ID = 192;
	public static final int EMPLEADO_MOSTRAR_POR_EMPLEADO_NOID = 193;
	
	
	//CLIENTE
	public static final int CLIENTE_VISTA = 200;
	public static final int CLIENTE_NUEVA_VISTA = 201;

	public static final int CLIENTE_CREAR = 210;
	public static final int CLIENTE_CREAR_VISTA = 211;
	public static final int CLIENTE_CREAR_ERROR = 212;
	public static final int CLIENTE_CREAR_REPEATED = 213;
	public static final int CLIENTE_CREAR_NUM_OVERFLOW= 214;
	public static final int CLIENTE_CREAR_SUCCESS = 215;
	public static final int CLIENTE_CREAR_EMPTY = 216;
	public static final int CLIENTE_CREAR_NIF_WRONG = 217;
	public static final int CLIENTE_CREAR_CIF_WRONG = 218;
	public static final int CLIENTE_CREAR_EMAIL_WRONG=219;
	
	
	public static final int CLIENTE_MODIFICAR = 220;
	public static final int CLIENTE_MODIFICAR_VISTA = 221;
	public static final int CLIENTE_MODIFICAR_NOTFOUND = 223;
	public static final int CLIENTE_MODIFICAR_SUCCESS = 225;
	public static final int CLIENTE_MODIFICAR_NUM_OVERFLOW= 226;
	public static final int CLIENTE_MODIFICAR_EMPTY = 228;
	public static final int CLIENTE_MODIFICAR_NIF_WRONG = 229;
	public static final int CLIENTE_MODIFICAR_CIF_WRONG = 222;
	public static final int CLIENTE_MODIFICAR_EMAIL_WRONG=224;
	
	public static final int CLIENTE_ELIMINAR = 230;
	public static final int CLIENTE_ELIMINAR_VISTA = 231;
	public static final int CLIENTE_ELIMINAR_ERROR = 232;
	public static final int CLIENTE_ELIMINAR_NOTFOUND = 233;
	public static final int CLIENTE_ELIMINAR_SUCCESS = 234;
	
	public static final int CLIENTE_MOSTRAR_UNO = 240;
	public static final int CLIENTE_MOSTRAR_UNO_VISTA = 241;
	public static final int CLIENTE_MOSTRAR_UNO_SI_ID = 243;
	public static final int CLIENTE_MOSTRAR_UNO_NO_ID = 242;
	
	public static final int CLIENTE_MOSTRAR_TODOS = 250;
	public static final int CLIENTE_MOSTRAR_TODOS_VISTA = 251;
	public static final int CLIENTE_MOSTRAR_TODOS_SUCCESS = 252;
	public static final int CLIENTE_MOSTRAR_TODOS_ERROR = 253;
	
	public static final int CLIENTE_MOSTRAR_PARTICULAR = 260;
	public static final int CLIENTE_MOSTRAR_PARTICULAR_VISTA = 261;
	public static final int CLIENTE_MOSTRAR_PARTICULAR_SUCCESS = 262;
	public static final int CLIENTE_MOSTRAR_PARTICULAR_ERROR = 263;
	
	public static final int CLIENTE_MOSTRAR_EMPRESA = 270;
	public static final int CLIENTE_MOSTRAR_EMPRESA_VISTA = 271;
	public static final int CLIENTE_MOSTRAR_EMPRESA_SUCCESS = 272;
	public static final int CLIENTE_MOSTRAR_EMPRESA_ERROR = 273;
	//RESERVA
	public static final int RESERVA_VISTA = 300;
	public static final int RESERVA_NUEVA_VISTA = 301 ;

	public static final int RESERVA_CREAR = 310;
	public static final int RESERVA_CREAR_VISTA = 311;
	public static final int RESERVA_CREAR_ERROR = 312;
	public static final int RESERVA_CREAR_WRONG_PARAMETERS= 313;
	public static final int RESERVA_CREAR_SUCCESS = 314;
	public static final int RESERVA_CREAR_CLIENTE_NOT_FOUND = 315;
	public static final int RESERVA_CREAR_CLIENTE_NOT_ACTIVE = 316;
	
	public static final int RESERVA_MODIFICAR = 320;
	public static final int RESERVA_MODIFICAR_VISTA = 321;
	public static final int RESERVA_MODIFICAR_WRONG_PARAMETERS = 322;
	public static final int RESERVA_MODIFICAR_NOTFOUND = 323;
	public static final int RESERVA_MODIFICAR_IDREPEATED = 324;
	public static final int RESERVA_MODIFICAR_SUCCESS = 325;
	public static final int RESERVA_MODIFICAR_CLIENTE_NOT_FOUND = 326;
	public static final int RESERVA_MODIFICAR_CLIENTE_NOT_ACTIVE = 327;
	
	public static final int RESERVA_ELIMINAR = 330;
	public static final int RESERVA_ELIMINAR_VISTA = 331;
	public static final int RESERVA_ELIMINAR_ERROR = 332;
	public static final int RESERVA_ELIMINAR_NOTFOUND = 333;
	public static final int RESERVA_ELIMINAR_SUCCESS = 334;
	
	public static final int RESERVA_MOSTRAR_UNA = 340;
	public static final int RESERVA_MOSTRAR_UNA_VISTA = 341;
	public static final int RESERVA_MOSTRAR_UNA_SI_ID = 343;
	public static final int RESERVA_MOSTRAR_UNA_NO_ID = 342;
	
	public static final int RESERVA_MOSTRAR_TODAS = 350;
	public static final int RESERVA_MOSTRAR_TODAS_VISTA = 351;
	public static final int RESERVA_MOSTRAR_TODAS_SUCCESS = 352;
	public static final int RESERVA_MOSTRAR_TODAS_ERROR = 353;
	
	public static final int RESERVA_QUITAR_HABITACIONES = 360;
	public static final int RESERVA_QUITAR_HABITACIONES_VISTA = 361;
	public static final int RESERVA_QUITAR_HABITACIONES_SUCCESS = 362;
	public static final int RESERVA_QUITAR_HABITACIONES_ERROR = 363;
	public static final int RESERVA_QUITAR_HABITACIONES_OCUPADA = 364;

	
	public static final int RESERVA_AÑADIR_HABITACIONES = 370;
	public static final int RESERVA_AÑADIR_HABITACIONES_VISTA = 371;
	public static final int RESERVA_AÑADIR_HABITACIONES_SUCCESS = 372;
	public static final int RESERVA_AÑADIR_HABITACIONES_NO_HABITACION = 373;
	public static final int RESERVA_AÑADIR_HABITACIONES_OCUPADA = 374;
	public static final int RESERVA_AÑADIR_HABITACIONES_NO_RESERVA = 375;
	public static final int RESERVA_AÑADIR_HABITACIONES_ERROR = 376;


	
	
	public static final int RESERVA_MOSTRAR_HABITACIONES = 380;
	public static final int RESERVA_MOSTRAR_HABITACIONES_VISTA = 381;
	public static final int RESERVA_MOSTRAR_HABITACIONES_SUCCESS = 382;
	public static final int RESERVA_MOSTRAR_HABITACIONES_FAILED = 383;
	
	public static final int RESERVA_MOSTRAR_RESERVA = 384;
	public static final int RESERVA_MOSTRAR_RESERVA_VISTA = 385;
	public static final int RESERVA_MOSTRAR_RESERVA_SUCCESS = 386;
	public static final int RESERVA_MOSTRAR_RESERVA_FAILED = 387;


	
	public static final int RESERVA_MOSTRAR_POR_CLIENTE = 390;
	public static final int RESERVA_MOSTRAR_POR_CLIENTE_VISTA = 391;
	public static final int RESERVA_MOSTRAR_POR_CLIENTE_SUCCESS = 392;
	public static final int RESERVA_MOSTRAR_POR_CLIENTE_FAILED = 393;
	
	//HABITACION
	public static final int HABITACION_VISTA = 400;
	public static final int HABITACION_NUEVA_VISTA = 401;
	
	public static final int HABITACION_CREAR = 410;
	public static final int HABITACION_CREAR_VISTA = 411;
	public static final int HABITACION_CREAR_ERROR = 412;
	public static final int HABITACION_CREAR_REPEATED = 413;
	public static final int HABITACION_CREAR_WRONG_PARAMETERS= 414;
	public static final int HABITACION_CREAR_SUCCESS = 415;
	public static final int HABITACION_CREAR_EMPLEADO_NOT_FOUND = 416;
	public static final int HABITACION_CREAR_EMPLEADO_NOT_ACTIVE = 417;
	
	public static final int HABITACION_ELIMINAR = 420;
	public static final int HABITACION_ELIMINAR_VISTA = 421;
	public static final int HABITACION_ELIMINAR_ERROR = 422;
	public static final int HABITACION_ELIMINAR_NOTFOUND = 423;
	public static final int HABITACION_ELIMINAR_SUCCESS = 424;
		
	public static final int HABITACION_MODIFICAR = 430;
	public static final int HABITACION_MODIFICAR_VISTA = 431;
	public static final int HABITACION_MODIFICAR_WRONG_PARAMETERS = 432;
	public static final int HABITACION_MODIFICAR_NOTFOUND = 433;
	public static final int HABITACION_MODIFICAR_IDREPEATED = 434;
	public static final int HABITACION_MODIFICAR_SUCCESS = 435;
	
	public static final int HABITACION_MOSTRAR_UNA = 440;
	public static final int HABITACION_MOSTRAR_UNA_VISTA = 441;
	public static final int HABITACION_MOSTRAR_UNA_SI_ID = 443;
	public static final int HABITACION_MOSTRAR_UNA_NO_ID = 442;
	
	public static final int HABITACION_MOSTRAR_TODAS = 450;
	public static final int HABITACION_MOSTRAR_TODAS_VISTA = 451;
	public static final int HABITACION_MOSTRAR_TODAS_SUCCESS = 452;
	public static final int HABITACION_MOSTRAR_TODAS_ERROR = 453;
	
	public static final int HABITACION_MOSTRAR_DISPONIBLES = 460;
	public static final int HABITACION_MOSTRAR_DISPONIBLES_VISTA = 461;
	public static final int HABITACION_MOSTRAR_DISPONIBLES_SUCCESS = 462;
	public static final int HABITACION_MOSTRAR_DISPONIBLES_ERROR = 462;

	
	public static final int HABITACION_MOSTRAR_POR_EMPLEADO = 470;
	public static final int HABITACION_MOSTRAR_POR_EMPLEADO_VISTA = 471;
	public static final int HABITACION_MOSTRAR_POR_EMPLEADO_ID = 472;
	public static final int HABITACION_MOSTRAR_POR_EMPLEADO_NOID= 473;
	
	//TAREA
	public static final int TAREA_VISTA = 500;
	public static final int TAREA_NUEVA_VISTA = 501 ;

	public static final int TAREA_CREAR = 510;
	public static final int TAREA_CREAR_VISTA = 511;
	public static final int TAREA_CREAR_ERROR = 512;
	public static final int TAREA_CREAR_REPEATED = 513;
	public static final int TAREA_CREAR_WRONG_PARAMETERS = 514;
	public static final int TAREA_CREAR_SUCCESS = 515;
	
	
	public static final int TAREA_MODIFICAR = 520;
	public static final int TAREA_MODIFICAR_VISTA = 521;
	public static final int TAREA_MODIFICAR_WRONG_PARAMETERS = 522;
	public static final int TAREA_MODIFICAR_NOTFOUND = 523;
	public static final int TAREA_MODIFICAR_IDREPEATED = 524;
	public static final int TAREA_MODIFICAR_SUCCESS = 525;
	
	public static final int TAREA_ELIMINAR = 530;
	public static final int TAREA_ELIMINAR_VISTA = 531;
	public static final int TAREA_ELIMINAR_ERROR = 532;
	public static final int TAREA_ELIMINAR_NOTFOUND = 533;
	public static final int TAREA_ELIMINAR_SUCCESS = 534;
	
	public static final int TAREA_MOSTRAR_UNO = 540;
	public static final int TAREA_MOSTRAR_UNA_VISTA = 541;

	public static final int TAREA_MOSTRAR_UNA_SI_ID = 543;
	public static final int TAREA_MOSTRAR_UNA_NO_ID = 542;
	
	public static final int TAREA_MOSTRAR_TODOS = 550;
	public static final int TAREA_MOSTRAR_TODAS_VISTA = 551;
	public static final int TAREA_MOSTRAR_TODAS_SUCCESS = 552;
	public static final int TAREA_MOSTRAR_TODAS_ERROR = 553;
	
	
	
	//DEPARTAMENTO
	public static final int DEPARTAMENTO_VISTA = 600;
	public static final int DEPARTAMENTO_NUEVA_VISTA = 601;

	public static final int DEPARTAMENTO_CREAR = 610;
	public static final int DEPARTAMENTO_CREAR_VISTA = 611;
	public static final int DEPARTAMENTO_CREAR_REPEATED = 612;
	public static final int DEPARTAMENTO_CREAR_WRONG_PARAMETERS = 613;
	public static final int DEPARTAMENTO_CREAR_SUCCESS = 615;
	
	
	public static final int DEPARTAMENTO_MODIFICAR = 620;
	public static final int DEPARTAMENTO_MODIFICAR_VISTA = 621;
	public static final int DEPARTAMENTO_MODIFICAR_WRONG_PARAMETERS = 622;
	public static final int DEPARTAMENTO_MODIFICAR_NOTFOUND = 623;
	public static final int DEPARTAMENTO_MODIFICAR_NAMEREPEATED = 624;
	public static final int DEPARTAMENTO_MODIFICAR_SUCCESS = 625;
	
	public static final int DEPARTAMENTO_ELIMINAR = 630;
	public static final int DEPARTAMENTO_ELIMINAR_VISTA = 631;
	public static final int DEPARTAMENTO_ELIMINAR_ERROR = 632;
	public static final int DEPARTAMENTO_ELIMINAR_NOTFOUND = 633;
	public static final int DEPARTAMENTO_ELIMINAR_SUCCESS = 634;
	
	public static final int DEPARTAMENTO_MOSTRAR_UNO = 640;
	public static final int DEPARTAMENTO_MOSTRAR_UNO_VISTA = 641;
	public static final int DEPARTAMENTO_MOSTRAR_UNO_SI_ID = 643;
	public static final int DEPARTAMENTO_MOSTRAR_UNO_NO_ID = 642;
	
	public static final int DEPARTAMENTO_MOSTRAR_TODOS = 650;
	public static final int DEPARTAMENTO_MOSTRAR_TODOS_VISTA = 651;
	public static final int DEPARTAMENTO_MOSTRAR_TODOS_SUCCESS = 652;
	public static final int DEPARTAMENTO_MOSTRAR_TODOS_ERROR = 653;
	
	
	

	
}
