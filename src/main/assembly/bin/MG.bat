SET MG_HOME=C:\mgservice-backend-1.0-bin

SET MG_BIN=%MG_HOME%\bin
SET MG_CONF=%MG_HOME%\conf
SET MG_LIB=%MG_HOM%\lib
SET MG_DEP=%MG_HOM%\lib\dep


echo MG_HOME=%MG_HOME%
echo MG_BIN=%MG_BIN%
echo MG_CONF=%MG_CONF%
echo MG_DEP=%MG_DEP%

SET CLASSPATH=""

for %%i in (%MG_DEP%\*.jar) do set CLASSPATH=%%i %CLASSPATH%;
for %%i in (%MG_LIB%\*.jar) do set CLASSPATH=%CLASSPATH%;%%i

set CLASSNAME=com.mg.service.backend.GenerateFilesMain

echo Starting...

java -Dconf.file=%MG_CONF%\config.properties -cp %CLASSPATH% %CLASSNAME%

echo End.

EXIT