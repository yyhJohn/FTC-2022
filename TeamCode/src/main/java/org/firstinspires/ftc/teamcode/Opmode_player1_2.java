package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

@TeleOp(name="player1 and player2")
public class Opmode_player1_2 extends LinearOpMode {
    Hardwaremap telehwp = new Hardwaremap();

    int p1 = 0;
    int p2 = 0;
    int a = 10;

    double M1,M2,M3,M4;
    double MotorMaxspeed=0.4;//0.7


    @Override
    public void runOpMode() throws InterruptedException {

        telehwp.init(hardwareMap);
        //telehwp.Leftfront1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //telehwp.Leftfront2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telehwp.Leftfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telehwp.Leftback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telehwp.Rightfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telehwp.Rightback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        /*telehwp.Leftfront1.setTargetPosition(0);
        telehwp.Leftfront2.setTargetPosition(0);
        telehwp.Leftfront1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telehwp.Leftfront2.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()){


            /*telehwp.Leftfront.setPower(gamepad1.left_stick_y);
            telehwp.Rightfront.setPower(gamepad1.left_stick_y);
            telehwp.Leftback.setPower(gamepad1.left_stick_y);
            telehwp.Rightback.setPower(gamepad1.left_stick_y);*/

            int position1 = telehwp.Leftfront.getCurrentPosition();
            int position2 = telehwp.Rightfront.getCurrentPosition();
            int position3 = telehwp.Leftback.getCurrentPosition();
            int position4 = telehwp.Rightback.getCurrentPosition();

            telemetry.addData("Leftfront Position", position1);
            telemetry.addData("Rightfront Position", position2);
            telemetry.addData("Leftback Position", position3);
            telemetry.addData("Rightback Position", position4);
            telemetry.update();

            /*    p1 += gamepad2.left_stick_x * a;
                telehwp.Leftfront1.setTargetPosition(p1);


                p2 += gamepad2.left_stick_y * a;
                telehwp.Leftfront1.setTargetPosition(p2);
            telehwp.Leftfront1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            telehwp.Leftfront2.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/


            //直连
            /*M1= (-gamepad1.left_stick_y-(gamepad1.left_stick_x*0.9)-(gamepad1.right_stick_x/2))*MotorMaxspeed;
            M2= (-gamepad1.left_stick_y+(gamepad1.left_stick_x*0.9)+(gamepad1.right_stick_x/2))*MotorMaxspeed;
            M3= (-gamepad1.left_stick_y+(gamepad1.left_stick_x*0.9)-(gamepad1.right_stick_x/2))*MotorMaxspeed;
            M4= (-gamepad1.left_stick_y-(gamepad1.left_stick_x*0.9)+(gamepad1.right_stick_x/2))*MotorMaxspeed;

            telehwp.Leftfront.setPower(M1);
            telehwp.Rightfront.setPower(M2);
            telehwp.Leftback.setPower(M3);
            telehwp.Rightback.setPower(M4);*/


            M1= -(gamepad1.left_stick_y-(gamepad1.left_stick_x*0.9)-(gamepad1.right_stick_x/2))*MotorMaxspeed;
            M2= (gamepad1.left_stick_y+(gamepad1.left_stick_x*0.9)+(gamepad1.right_stick_x/2))*MotorMaxspeed;
            M3= -(gamepad1.left_stick_y+(gamepad1.left_stick_x*0.9)-(gamepad1.right_stick_x/2))*MotorMaxspeed;
            M4= (gamepad1.left_stick_y-(gamepad1.left_stick_x*0.9)+(gamepad1.right_stick_x/2))*MotorMaxspeed;

            telehwp.Leftfront.setPower(M1);
            telehwp.Rightfront.setPower(M2);
            telehwp.Leftback.setPower(M3);
            telehwp.Rightback.setPower(M4);



            /*if (gamepad1.right_stick_x>=0){
                telehwp.Leftfront.setPower(gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Leftback.setPower(gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightfront.setPower(gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightback.setPower(gamepad1.right_stick_x*MotorMaxspeed);
            }

            if (gamepad1.right_stick_x<=0){
                telehwp.Leftfront.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Leftback.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightfront.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightback.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
            }


            if (gamepad1.left_stick_y>=0){
                telehwp.Leftfront.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Leftback.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightfront.setPower(gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightback.setPower(gamepad1.right_stick_x*MotorMaxspeed);
            }

            if (gamepad1.left_stick_y<=0){
                telehwp.Leftfront.setPower(gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Leftback.setPower(gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightfront.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
                telehwp.Rightback.setPower(-gamepad1.right_stick_x*MotorMaxspeed);
            }*/

            //telehwp.arm_motor.setPower(gamepad1.right_stick_x);

        }

    }
}
