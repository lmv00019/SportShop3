
$(() =>  {
    let ctrl = new valida();
    ctrl.init(); //attach view-event handlers
});

class valida {
    constructor () {
        this.config= { //view-model
            idni:"[name=dni]",
            btDNI:"#btDNI",
            salida:"#mensaje",
            ERdni:/^(\d{8})([a-zA-Z])$/
        };
        console.log("Controlador inicializado");
    }
    init () {
        $(this.config.btDNI).on('click', () => {
            this.validaDNI();
        });
        console.log("Manejadores de eventos enlazados");
    }
    validaDNI() {
        var dni=$(this.config.idni).val().trim();
        var mensaje="Tu dni "+dni;
        if (this.config.ERdni.test(dni)) {

            mensaje+= " es correcto";
            console.log("Se ha aceptado el dni %s",dni);
        }else {
            mensaje+= " es incorrecto";
        }
        $(this.config.salida).text(mensaje);
    }
}