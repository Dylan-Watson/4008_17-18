package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name=" Red Auton", group="")
//@Disabled
public class AutoRed extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareMap4008         robot   = new HardwareMap4008();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        robot.initializeRobotPositions();

        waitForStart();

        robot.setMidJewel();

        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() < 1)){}

        robot.lowerJewel();

        while(opModeIsActive()){
            telemetry.addData("Current Values", "Red: " + robot.colorSensor.red());
            telemetry.addData("Current Values", "Blue: " + robot.colorSensor.blue());
        }

    }
}
