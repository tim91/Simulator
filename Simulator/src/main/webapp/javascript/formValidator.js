$(document).ready(function() {
	
	applyFormValidator();
});


var applyFormValidator = function(){
	var pusteMSG = 'Pole nie może być puste';
	var notIntegerMSG = 'Wartosć nie jest liczba';
	var valMin = 0;
	var valMax = 10000;
	var wrongVal = 'Wartoć powinna być z przedziału od: ' + valMin + ' do: ' + valMax;
	
    $('#startDataForm').bootstrapValidator({
        fields: {
            posX: {
                validators: {
                    notEmpty: {
                        message: pusteMSG
                    },
                    integer: {
                        message: notIntegerMSG
                    },
                    between: {
                        min: valMin,
                        max: valMax,
                        message: wrongVal
                    }
                }
            },
            posY: {
                validators: {
                    notEmpty: {
                        message: pusteMSG
                    },
                    integer: {
                        message: notIntegerMSG
                    },
                    between: {
                        min: valMin,
                        max: valMax,
                        message: wrongVal
                    }
                }
            },
            posZ: {
                validators: {
                    notEmpty: {
                        message: pusteMSG
                    },
                    integer: {
                        message: notIntegerMSG
                    },
                    between: {
                        min: valMin,
                        max: valMax,
                        message: wrongVal
                    }
                }
            },
            velX: {
                validators: {
                    notEmpty: {
                        message: pusteMSG
                    },
                    integer: {
                        message: notIntegerMSG
                    },
                    between: {
                        min: valMin,
                        max: valMax,
                        message: wrongVal
                    }
                }
            },
            velY: {
                validators: {
                    notEmpty: {
                        message: pusteMSG
                    },
                    integer: {
                        message: notIntegerMSG
                    },
                    between: {
                        min: valMin,
                        max: valMax,
                        message: wrongVal
                    }
                }
            },
            velZ: {
                validators: {
                    notEmpty: {
                        message: pusteMSG
                    },
                    integer: {
                        message: notIntegerMSG
                    },
                    between: {
                        min: valMin,
                        max: valMax,
                        message: wrongVal
                    }
                }
            },
        },
        submitHandler: function(validator, form, submitButton) {
        	
        	var posX = validator.getFieldElements('posX').val();
        	var posY = validator.getFieldElements('posY').val();
        	var posZ = validator.getFieldElements('posZ').val();
        	var velX = validator.getFieldElements('posX').val();
        	var velY = validator.getFieldElements('velY').val();
        	var velZ = validator.getFieldElements('velZ').val();
        	
        	tab = {};
        	tab['posX'] = parseFloat(posX);
        	tab['posY'] = parseFloat(posY);
        	tab['posZ'] = parseFloat(posZ);
        	tab['velX'] = parseFloat(velX);
        	tab['velY'] = parseFloat(velY);
        	tab['velZ'] = parseFloat(velZ);
        	
            init(tab);
        }
    });
}