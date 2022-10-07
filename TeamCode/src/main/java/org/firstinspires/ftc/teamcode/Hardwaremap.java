package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Hardwaremap {

    DcMotor Leftfront=null; //2
    DcMotor Rightfront=null; //1
    DcMotor Leftback=null; //3
    DcMotor Rightback=null; //0

    HardwareMap hwp=null;
    //DcMotor arm_motor =null;

    public Hardwaremap(){}

    public void init(HardwareMap HwMap){
        hwp=HwMap;
        /*Rightback = hwp.get(DcMotorEx.class, "RightBack");
        Leftback = hwp.get(DcMotorEx.class, "LeftBack");
        Rightfront = hwp.get(DcMotorEx.class, "RightFront");*/
        Leftfront = hwp.get(DcMotor.class, "Leftfront");
        Rightfront = hwp.get(DcMotor.class, "Rightfront");
        Leftback = hwp.get(DcMotor.class, "Leftback");
        Rightback = hwp.get(DcMotor.class, "Rightback");






        Leftfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Leftback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Rightback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Rightfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Leftfront1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //Leftfront2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        /*Leftfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Rightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Leftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Rightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/

        //左前和左后需反转


        /*arm_motor = hwp.dcMotor.get("arm");

        arm_motor.setDirection(DcMotorSimple.Direction.REVERSE);


         */
    }
}
