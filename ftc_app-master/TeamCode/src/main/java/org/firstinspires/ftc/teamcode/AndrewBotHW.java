package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by BroncBotz on 10/17/2017.
 */

public class AndrewBotHW {

    public DcMotor FLM,FRM,BLM,BRM,ILM,IRM,LGLM,RGLM;
    public TouchSensor touch;

    public Servo jewelManipulator, glyphGuideLeft,glyphGuideright, manipLeft, manipRight;
    public ColorSensor colorSensor;


    HardwareMap hwMap = null;


    public AndrewBotHW(){}

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        FLM = hwMap.get(DcMotor.class, "fl");
        FRM = hwMap.get(DcMotor.class, "fr");
        FLM.setDirection(DcMotorSimple.Direction.REVERSE);
        BLM = hwMap.get(DcMotor.class, "bl");
        BRM = hwMap.get(DcMotor.class, "br");
        BLM.setDirection(DcMotorSimple.Direction.REVERSE);

        jewelManipulator = hwMap.get(Servo.class, "jewelServo");
        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        glyphGuideLeft = hwMap.get(Servo.class, "GGL");
        glyphGuideright = hwMap.get(Servo.class,"GGR");
        manipLeft = hwMap.get(Servo.class, "sML");
        manipRight = hwMap.get(Servo.class, "sMR");

        //ILM = hwMap.get(DcMotor.class, "il");
        //IRM = hwMap.get(DcMotor.class, "ir");
        //touch = hwMap.get(TouchSensor.class, "touch");

        //LGLM = hwMap.get(DcMotor.class, "gl");
        //RGLM = hwMap.get(DcMotor.class, "gr");

        FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //LGLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //RGLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //ILM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //IRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //ILM.setDirection(DcMotorSimple.Direction.REVERSE);

    }

}
