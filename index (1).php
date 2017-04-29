 <?php
        
	$backward = shell_exec("/usr/local/bin/gpio -g mode 17 out");
	$forward = shell_exec("/usr/local/bin/gpio -g mode 4 out");
	$right = shell_exec("/usr/local/bin/gpio -g mode 27 out");
	$left = shell_exec("/usr/local/bin/gpio -g mode 22 out");


	if(isset($_GET['connect']))
	{
                 $g1 = shell_exec("/usr/local/bin/gpio -g write  17 1");
                 $g2 = shell_exec("/usr/local/bin/gpio -g write  4 1");
                 $g3 = shell_exec("/usr/local/bin/gpio -g write  27 1");
                 $g4 = shell_exec("/usr/local/bin/gpio -g write  22 1");
                 echo "connected.. ";
        }

	if(isset($_GET['disconnect']))
	{
                 $g1 = shell_exec("/usr/local/bin/gpio -g write  17 0");
                 $g2 = shell_exec("/usr/local/bin/gpio -g write  4 0");
                 $g3 = shell_exec("/usr/local/bin/gpio -g write  27 0");
                 $g4 = shell_exec("/usr/local/bin/gpio -g write  22 0");
                 echo "disconnected.. ";
        }


	//left on
        if(isset($_GET['leftOn']))
	{
                 $gpio_on = shell_exec("/usr/local/bin/gpio -g write 22 0");
                 echo "left is on ";
        }
	//left off
        if(isset($_GET['leftOff']))
	{
                 $gpio_off = shell_exec("/usr/local/bin/gpio -g write 22 1");
                 echo "left is off ";
        }


	//right on
	if(isset($_GET['rightOn']))
	{
                 $gpio_on = shell_exec("/usr/local/bin/gpio -g write  27 0");
                 echo "right is on ";
        }
	//right off
	if(isset($_GET['rightOff']))
	{
                 $gpio_on = shell_exec("/usr/local/bin/gpio -g write  27 1");
                 echo "right is off ";
        }


	//forward on
	if(isset($_GET['forOn']))
	{
                 $gpio_on = shell_exec("/usr/local/bin/gpio -g write  4 0");
                 echo "for is on ";
        }
	//forward off
	if(isset($_GET['forOff']))
	{
                 $gpio_on = shell_exec("/usr/local/bin/gpio -g write  4 1");
                 echo "for is off ";
        }


	//back on
	if(isset($_GET['backOn']))
	{
                 $gpio_on = shell_exec("/usr/local/bin/gpio -g write  17 0");
                 echo "back is on ";
        }
	//back off
	if(isset($_GET['backOff']))
	{
                 $gpio_on = shell_exec("/usr/local/bin/gpio -g write  17 1");
                 echo "back is off ";
        }
?>