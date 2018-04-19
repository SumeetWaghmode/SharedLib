/**
 * This map contains the nodes and TC_ROOT/DATA which should be used for each release
 * @param release Name of the release
 */
def call(String workspaceLocation) 
{
	echo workspaceLocation
	try {
			bat """@echo on
					cd /d workspaceLocation
					mvn install"""

			//archiveArtifacts artifacts: 'client_customization/client_binaries/**', fingerprint: true
			//stash name: "winJars", includes: "client_customization/client_binaries/**"
			//reportTestResult {
			//	classname = 'com.siemens.plm2020.build'
			//	testname = 'buildWinJars'
			//}
		} catch (Exception e) {
			println "Error is --> " + e.getMessage()
			reportTestResult {
				classname = 'com.siemens.plm2020.build'
				testname = 'buildWinJars'
				failure = e.getMessage()
			}
			return e
		}
}