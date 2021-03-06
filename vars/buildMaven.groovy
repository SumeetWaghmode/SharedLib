/**
 * This map contains the nodes and TC_ROOT/DATA which should be used for each release
 * @param release Name of the release
 */
def call(String workspaceLocation) 
{
	echo workspaceLocation
	try {
			if (isUnix()) 
			{
			
			}
			else
			{
				bat """@echo on
					set M2_HOME=E:/Apps/apache-maven-3.5.3
					set PATH=%PATH%;E:/Apps/apache-maven-3.5.3/bin
					cd  ExportXlsService
					mvn install"""
			}

			archiveArtifacts artifacts: 'ExportXlsService/target/*.war*', fingerprint: true
			stash name: "winJars", includes: "ExportXlsService/target/**"
			//reportTestResult {
			//	classname = 'com.siemens.plm2020.build'
			//	testname = 'buildWinJars'
			//}
		} catch (Exception e) {
			println "Error is --> " + e.getMessage()			
			return e
		}
}