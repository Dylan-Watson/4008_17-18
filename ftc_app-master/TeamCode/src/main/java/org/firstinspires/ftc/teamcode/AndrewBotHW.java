package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.source.tree.BreakTree;

/**
 * Created by BroncBotz on 10/17/2017.
 */

public class AndrewBotHW {

    /** Initialize Static Numerical Variables **/
    double jewelUpPos = 0.1;
    double jewelDownPos = 0.1;

    double glyphClosePosBL = 0.1;
    double glyphOpenPosBL = 0.1;
    double glyphClosePosBR = 0.1;
    double glyphOpenPosBR = 0.1;
    double glyphClosePosFL = 0.1;
    double glyphOpenPosFL = 0.1;
    double glyphClosePosFR = 0.1;
    double glyphOpenPosFR = 0.1;

    double wheelOpenL = 0.1;
    double wheelCloseL = 0.1;
    double wheelOpenR = 0.1;
    double wheelCloseR = 0.1;

    /**
     * FLM,FRM,BLM,BRM: The motors controlling the drivtrain
     * ILM,IRM: The motors controlling the rotation of the intake wheels
     *      Note: To control the pressure applied by the wheels, look at the servos defined below
     * LLM,LRM: The motors controlling the lifting of the lift
     */
    public DcMotor FLM,FRM,BLM,BRM,ILM,IRM,LLM,LRM;

    /**
     * jewelManip: The servo for manipulating the jewel
     * glyphGL,glyphGR: The servos that control the poles to grip the glyphs from the back of the robot
     * wheelL,wheelR: The servos that control the wheel pressures at the front of the robot
     *      NOTE: For the wheels at the fron of the robot, if looking to use notation, reference the motors above
     * outtake393: The VEX 393 motor responsible for the outtake of the glyphs
     * glyphGHL,glyphGHR: The helper servos in the fron of the robot that help provide pressure points through the poles onto the glyphs
     */
    //TODO: Figure out the CR Servo stuff and how to use it
    //NOTE: The CR servos are not here right now
    public Servo jewelManip, glyphGL, glyphGR, wheelL, wheelR, outtake393, glyphGHL, glyphGHR;

    /**
     * The sensor to detect the color of the jewels
     */
    public ColorSensor colorSensor;


    HardwareMap hwMap = null;


    public AndrewBotHW(){}

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;

        /** Initialize Motors **/

        //Left is currently reversed, this needs to be tested
        FLM = hwMap.get(DcMotor.class, "fl");
        FRM = hwMap.get(DcMotor.class, "fr");
        BLM = hwMap.get(DcMotor.class, "bl");
        BRM = hwMap.get(DcMotor.class, "br");
        FLM.setDirection(DcMotorSimple.Direction.REVERSE);
        BLM.setDirection(DcMotorSimple.Direction.REVERSE);
        FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Left is currently reversed, this needs to be tested
        ILM = hwMap.get(DcMotor.class, "il");
        IRM = hwMap.get(DcMotor.class, "ir");
        ILM.setDirection(DcMotorSimple.Direction.REVERSE);
        ILM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        IRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        //Left is currently reversed, this needs to be tested
        LLM = hwMap.get(DcMotor.class, "llm");
        LRM = hwMap.get(DcMotor.class, "lrm");
        LLM.setDirection(DcMotorSimple.Direction.REVERSE);
        LLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /** Initialize Servos **/

        jewelManip = hwMap.get(Servo.class, "js");
        colorSensor = hwMap.get(ColorSensor.class, "col");
        glyphGL = hwMap.get(Servo.class, "ggl");
        glyphGR = hwMap.get(Servo.class,"ggr");
        wheelL = hwMap.get(Servo.class, "wl");
        wheelR = hwMap.get(Servo.class, "wr");
        outtake393 = hwMap.get(Servo.class, "vex");
        glyphGHL = hwMap.get(Servo.class, "gghl");
        glyphGHR = hwMap.get(Servo.class, "gghr");

    }

    public void initializeRobotPositions(){
        //put the jewel thing up
        //set the poles to ungrip
        //set wheels to grip
        //set CR to intake position???
    }

}
