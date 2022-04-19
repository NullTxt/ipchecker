package com.kaho__.ipchecker;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import java.net.*;
import java.io.*;


@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "ipchecker";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) throws IOException {
        try {
            //get the public ip
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

            String ip = in.readLine(); //you get the IP as a String
            //print console in red
            System.out.println("\033[0;31m" + ip + "\033[0m");
            throw new Error("Ip isnt masked") {
                @Override
                public void printStackTrace() {
                    throw new Error("Ip isnt masked");
                }
            };
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
