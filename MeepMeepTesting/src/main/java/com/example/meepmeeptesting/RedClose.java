package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class RedClose {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(1200);

        Pose2d startPose = new Pose2d(10, -61, Math.toRadians(90));

        RoadRunnerBotEntity redLeft = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 18)
                .build();

        redLeft.runAction(redLeft.getDrive().actionBuilder(startPose)
                .setTangent(0)
                .splineToSplineHeading(new Pose2d(10, -29, Math.toRadians(180)), Math.PI / 2)

                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(redLeft)
                .start();
    }
}
