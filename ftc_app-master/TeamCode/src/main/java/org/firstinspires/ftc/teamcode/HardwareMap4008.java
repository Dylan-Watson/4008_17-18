package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by BroncBotz on 10/17/2017.
 */

public class HardwareMap4008 {

    /** Initialize Static Numerical Variables **/
    double jewelUpPos = .43;
    double jewelDownPos = 0.00;

    double jewelMidPos = 0.45;
    double jewelBackPos = 0.90;
    double jewelFrontPos = 0.20;

//BR VALUES HAVE NOT BEEN TESTED, JUST DUMMY VALUES
    double glyphClosePosBL = 0.55;
    double glyphOpenPosBL = 0.00;
    double glyphClosePosFL = 1.00;
    double glyphOpenPosFL = 0.7;
    double glyphClosePosFR = 0.00;
    double glyphOpenPosFR = 0.3;
    double glyphClosePosBR = 0.1;
    double glyphOpenPosBR = 0.1;

    double wheelOpenR = 0.1;
    double wheelCloseR = 0.1;

    public boolean isGripped = false;

    /**
     * FLM,FRM,BLM,BRM: The motors controlling the drivtrain
     * ILM,IRM: The motors controlling the rotation of the intake wheels
     *      Note: To control the pressure applied by the wheels, look at the servos defined below
     * LAM,RAM: The motors controlling the lifting of the lift
     */

    public DcMotor FLM,FRM,BLM,BRM,ILM,IRM,LAM,RAM;

    /**
     * jewelUpDown: The servo for manipulating the jewel
     * glyphGL,glyphGR: The servos that control the poles to grip the glyphs from the back of the robot
     * wheelL,wheelR: The servos that control the wheel pressures at the front of the robot
     *      NOTE: For the wheels at the fron of the robot, if looking to use notation, reference the motors above
     * outtake393: The VEX 393 motor responsible for the outtake of the glyphs
     * glyphGHL,glyphGHR: The helper servos in the fron of the robot that help provide pressure points through the poles onto the glyphs
     */
    //TODO: Figure out the CR Servo stuff and how to use it
    //NOTE: The CR servos are not here right now
    //Default wheel position is closed. Only change to open when lifting

 /**
    public Servo jewelUpDown;
    public Servo glyphGL;

    public Servo wheelR;
    public Servo outtake393;
  */


    public CRServo CRLeft;
    public CRServo CRRight;



    public Servo grabberFrontLeft, grabberRearLeft, grabberFrontRight, grabberRearRight, jewelUpDown, jewelFrontBack;



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
        FLM = hwMap.get(DcMotor.class, "FL");
        FRM = hwMap.get(DcMotor.class, "FR");
        BLM = hwMap.get(DcMotor.class, "BL");
        BRM = hwMap.get(DcMotor.class, "BR");
        FLM.setDirection(DcMotorSimple.Direction.REVERSE);
        BLM.setDirection(DcMotorSimple.Direction.REVERSE);
        FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Left is currently reversed, this needs to be tested
        ILM = hwMap.get(DcMotor.class, "IL");
        IRM = hwMap.get(DcMotor.class, "IR");
        ILM.setDirection(DcMotorSimple.Direction.REVERSE);
        ILM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        IRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        //Left is currently reversed, this needs to be tested
        LAM = hwMap.get(DcMotor.class, "LA");
        RAM = hwMap.get(DcMotor.class, "RA");
        LAM.setDirection(DcMotorSimple.Direction.REVERSE);
        LAM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RAM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);





        /** Initialize Servos **/

        jewelUpDown = hwMap.get(Servo.class, "jud");
        jewelFrontBack = hwMap.get(Servo.class, "jbf");
        colorSensor = hwMap.get(ColorSensor.class, "col");


        grabberFrontLeft = hwMap.get(Servo.class, "GBFL");

        grabberFrontLeft.setDirection(Servo.Direction.REVERSE);
        grabberRearLeft = hwMap.get(Servo.class,"GBRL");
        grabberFrontRight = hwMap.get(Servo.class,"GBFR");
        grabberRearRight = hwMap.get(Servo.class, "GBRR");
        CRLeft = hwMap.get(CRServo.class, "GRL");
        CRRight = hwMap.get(CRServo.class, "GRR");
        CRLeft.setDirection(CRServo.Direction.REVERSE);

      //  initializeRobotPositions();

    }

    public void initializeRobotPositions(){
        colorSensor.enableLed(true);
        jewelUpDown.setPosition(jewelUpPos);
    }

    public void lowerJewel(){
        colorSensor.enableLed(true);
        jewelUpDown.setPosition(jewelDownPos);
    }

    public void setMidJewel(){
        jewelFrontBack.setPosition(jewelMidPos);
    }

    public void setJewelBackPos(){
        jewelFrontBack.setPosition(jewelBackPos);
    }

    public void setJewelFrontPos(){
        jewelFrontBack.setPosition(jewelFrontPos);
    }

    public void raiseJewel(){
        colorSensor.enableLed(false);
        jewelUpDown.setPosition(jewelUpPos);
    }
    public void intakeGlyph(){
        //make sure to check that the lift is down before even calling this method
       // wheelR.setPosition(wheelCloseR);
        ILM.setPower(1);
        IRM.setPower(1);
    }

    public void stopIntake(){
        ILM.setPower(0);
        IRM.setPower(0);
    }

    public void openWheels(){
      //  wheelR.setPosition(wheelOpenR);
    }

    public void outtakeGlyphOnGround(){

     //   wheelR.setPosition(wheelCloseR);
        ILM.setPower(-1);
        IRM.setPower(-1);
    }

    public void gripGlyph(){
        //you can do a toggle cause its non-resetting servos
        grabberRearLeft.setPosition(glyphClosePosBL);
        grabberFrontLeft.setPosition(glyphClosePosFL);
        grabberFrontRight.setPosition(glyphClosePosFR);
        grabberRearRight.setPosition(glyphClosePosBR);
        isGripped = true;
    }

    public void ungripGlyph(){

        grabberFrontRight.setPosition(glyphOpenPosFR);
        grabberRearLeft.setPosition(glyphOpenPosBL);
        grabberFrontLeft.setPosition(glyphOpenPosFL);
        grabberRearRight.setPosition(glyphOpenPosBR);

        isGripped = false;
    }

    public void raiseArm(){
        openWheels();

        LAM.setPower(.8);
        RAM.setPower(.8);
    }

    public void lowerArm(){
        LAM.setPower(-.8);
        RAM.setPower(-.8);
    }

public void stopArm(){
        LAM.setPower(0);
        RAM.setPower(0);
    }

    public void stopOperatorMotors(){
        LAM.setPower(0);
        RAM.setPower(0);
        ILM.setPower(0);
        IRM.setPower(0);
    }

    public void stopRobot(){
        //only call this for auton
        LAM.setPower(0);
        RAM.setPower(0);
        ILM.setPower(0);
        IRM.setPower(0);
        BLM.setPower(0);
        BRM.setPower(0);
        FLM.setPower(0);
        FRM.setPower(0);
    }

    public void outtakeGlyphRaised(){
        //outtake393.setPosition(0);
    }

    public void stopRaisedOuttake(){
        //outtake393.setPosition(.5);
    }


    public void grabberHomePosition(){
        CRLeft.setPower(.2);
        CRRight.setPower(.2);
    }
    //High Score
    public void grabberTilt1(){
        CRLeft.setPower(.3);
        CRRight.setPower(.3);
    }
    //Low Score
    public void grabberTilt2(){
        CRLeft.setPower(.05);
        CRRight.setPower(.05);
    }


    public void raiseGlyphCR(){

        CRLeft.setPower(.5);
       CRRight.setPower(.5);
    }


    public void stopCRServos(){
        CRLeft.setPower(0);
        CRRight.setPower(0);
    }

    public void driveFoward(){
        BLM.setPower(.50);
        BRM.setPower(.50);
        FLM.setPower(.50);
        FRM.setPower(.50);
    }

    public void driveBack(){
        BLM.setPower(-.50);
        BRM.setPower(-.50);
        FLM.setPower(-.50);
        FRM.setPower(-.50);
    }

    public void stopDrive(){
        BLM.setPower(0);
        BRM.setPower(0);
        FLM.setPower(0);
        FRM.setPower(0);
    }

}
