package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Blue Auton", group="")
public class AutoBlue extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareMap4008         robot   = new HardwareMap4008();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();

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

        robot.lowerJewel();

        double red = robot.colorSensor.red();
        double blue = robot.colorSensor.blue();

        if(red > blue && red > 2){
            telemetry.addData("Color Detection", "RED DETECTED WITH A VALUE OF: ", red);
            telemetry.update();
            robot.driveBack();
            runtime.reset();
            while(opModeIsActive() && (runtime.seconds() < 1.5)){
                telemetry.addData("Path", "Going backwards to hit off red" + runtime.seconds());
                telemetry.update();
            }
            robot.stopDrive();
        }

        //if it detects blue, go fowards


    }
}
