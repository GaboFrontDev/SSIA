@ECHO OFF 
javac -cp lib/jade.jar src/myAgents/*.java -d classes/ && java -cp ./lib/jade.jar;classes/ jade.Boot -gui
PAUSE