package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;

/**
 * Created by BroncBotz on 10/17/2017.
 */

public class HardwareMap4008 {

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

    double wheelOpenR = 0.1;
    double wheelCloseR = 0.1;

    public boolean isGripped = false;

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
    //Default wheel position is closed. Only change to open when lifting
    public Servo jewelManip;
    public Servo glyphGL;
    public Servo glyphGR;
    public Servo wheelR;
    public Servo outtake393;
    public Servo glyphGHL;
    public Servo glyphGHR;
    public CRServo CRLeft;
    public CRServo CRRight;

    /**
     * colorSensor: The sensor to detect the color of the jewels
     * pot: The potentiometer for the lift
     */
    public ColorSensor colorSensor;
    //public AnalogInput pot;
    //double potRead = pot.getVoltage()/5 * 100;



    HardwareMap hwMap = null;


    public HardwareMap4008(){}

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
        wheelR = hwMap.get(Servo.class, "wr");
        outtake393 = hwMap.get(Servo.class, "vex");
        glyphGHL = hwMap.get(Servo.class, "gghl");
        glyphGHR = hwMap.get(Servo.class, "gghr");

        CRLeft = hwMap.get(CRServo.class, "crl");
        CRRight = hwMap.get(CRServo.class, "crr");
        CRLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        initializeRobotPositions();

    }

    public void initializeRobotPositions(){
        jewelManip.setPosition(jewelUpPos);
        glyphGL.setPosition(glyphOpenPosBL);
        glyphGR.setPosition(glyphOpenPosBR);
        glyphGHL.setPosition(glyphOpenPosFL);
        glyphGHR.setPosition(glyphOpenPosFR);
        wheelR.setPosition(wheelCloseR);
        //set CR to intake position???
    }

    public void lowerJewel(){
        jewelManip.setPosition(jewelDownPos);
    }

    public void raiseJewel(){
        jewelManip.setPosition(jewelUpPos);
    }

    public void intakeGlyph(){
        //make sure to check that the lift is down before even calling this method
        wheelR.setPosition(wheelCloseR);
        ILM.setPower(.5);
        IRM.setPower(.5);
    }

    public void stopIntake(){
        ILM.setPower(0);
        IRM.setPower(0);
    }

    public void openWheels(){
        wheelR.setPosition(wheelOpenR);
    }

    public void outtakeGlyphOnGround(){
        ungripGlyph();
        wheelR.setPosition(wheelCloseR);
        ILM.setPower(-.5);
        IRM.setPower(-.5);
    }

    public void gripGlyph(){
        //you can do a toggle cause its non-resetting servos
        glyphGL.setPosition(glyphClosePosBL);
        glyphGR.setPosition(glyphClosePosBR);
        glyphGHL.setPosition(glyphClosePosFL);
        glyphGHR.setPosition(glyphClosePosFR);
        isGripped = true;
    }

    public void ungripGlyph(){
        glyphGL.setPosition(glyphOpenPosBL);
        glyphGR.setPosition(glyphOpenPosBR);
        glyphGHL.setPosition(glyphOpenPosFL);
        glyphGHR.setPosition(glyphOpenPosFR);
        isGripped = false;
    }

    public void raiseArm(){
        openWheels();
        gripGlyph();
        LLM.setPower(.5);
        LRM.setPower(.5);
    }

    public void lowerArm(){
        LLM.setPower(.5);
        LRM.setPower(.5);
    }

    public void stopArm(){
        LLM.setPower(0);
        LRM.setPower(0);
    }

    public void stopOperatorMotors(){
        LLM.setPower(0);
        LRM.setPower(0);
        ILM.setPower(0);
        IRM.setPower(0);
    }

    public void stopRobot(){
        //only call this for auton
        LLM.setPower(0);
        LRM.setPower(0);
        ILM.setPower(0);
        IRM.setPower(0);
        BLM.setPower(0);
        BRM.setPower(0);
        FLM.setPower(0);
        FRM.setPower(0);
    }

    public void outtakeGlyphRaised(){
        outtake393.setPosition(0);
    }

    public void stopRaisedOuttake(){
        outtake393.setPosition(.5);
    }

    public void raiseGlyphCR(){
        CRLeft.setPower(.5);
        CRRight.setPower(.5);
    }

    public void lowerGlyphCR(){
        CRLeft.setPower(-.5);
        CRRight.setPower(-.5);
    }

    public void stopCRServos(){
        CRLeft.setPower(0);
        CRRight.setPower(0);
    }

}
