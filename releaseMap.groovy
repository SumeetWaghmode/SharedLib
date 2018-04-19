/**
 * This map contains the nodes and TC_ROOT/DATA which should be used for each release
 * @param release Name of the release
 */
def call(String release) {
	def releaseNodeMap = [
		intranetv3: [
			winBuildNode   : 'IEC_Build_Win',
			lnxBuildNode   : 'PLM2020_SB3',
			winBuildTcBase: 'E:/PLM2020/tc11.2.3.1',
			winVSBase: 'E:/TC_APPL/VS2012',
			winJavaBase: 'E:/TC_APPL/Java/jdk1.8.0_51',
			winJREBase: 'E:/TC_APPL/Java/jre1.8.0_51',
			winBuildLibOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/DepLib/R21',
			winBuildDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/R21',
			winBuildlogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/server_dlls_logs/R21',
			winBMIDEDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/R21',
			winBMIDElogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/bmide_logs/R21',
			lnxBuildSOOutput :  '/hd1a/home/tci01c03/sandbox/Linux_x86_64/lib',
			lnxLogPath :  'Logs',
			winLogPath :  'Logs',
		],
		R2: [
			winBuildNode   : 'IEC_Build_Win',
			lnxBuildNode   : 'PLM2020_SB3',
			winBuildTcBase: 'E:/PLM2020/tc11.2.3.1',
			winVSBase: 'E:/TC_APPL/VS2012',
			winJavaBase: 'E:/TC_APPL/Java/jdk1.8.0_51',
			winJREBase: 'E:/TC_APPL/Java/jre1.8.0_51',
			winBuildLibOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/DepLib/R2',
			winBuildDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/R2',
			winBuildlogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/server_dlls_logs/R2',
			winBMIDEDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/R2',
			winBMIDElogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/bmide_logs/R2',
			lnxBuildSOOutput :  '/hd1a/home/tci01c03/sandbox/Linux_x86_64/lib',
			lnxLogPath :  'Logs',
			winLogPath :  'Logs',
		],
		FS: [
			winBuildNode   : 'IEC_Build_Win',
			lnxBuildNode   : 'PLM2020_SB3',
			winBuildTcBase: 'E:/PLM2020/tc11.2.3.1',
			winVSBase: 'E:/TC_APPL/VS2012',
			winJavaBase: 'E:/TC_APPL/Java/jdk1.8.0_51',
			winJREBase: 'E:/TC_APPL/Java/jre1.8.0_51',
			winBuildLibOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/DepLib/FS',
			winBuildDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/FS',
			winBuildlogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/server_dlls_logs/FS',
			winBMIDEDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/FS',
			winBMIDElogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/bmide_logs/FS',
			lnxBuildSOOutput :  '/hd1a/home/tci01c03/sandbox/Linux_x86_64/lib',
			lnxLogPath :  'Logs',
			winLogPath :  'Logs',
		],
		MBD: [
			winBuildNode   : 'IEC_Build_Win',
			lnxBuildNode   : 'PLM2020_SB3',
			winBuildTcBase: 'E:/PLM2020/tc11.2.3.1',
			winVSBase: 'E:/TC_APPL/VS2012',
			winJavaBase: 'E:/TC_APPL/Java/jdk1.8.0_51',
			winJREBase: 'E:/TC_APPL/Java/jre1.8.0_51',
			winBuildLibOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/DepLib/MBD',
			winBuildDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/MBD',
			winBuildlogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/server_dlls_logs/MBD',
			winBMIDEDLLOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/WinLibs/MBD',
			winBMIDElogOutput :  'E:/jenkins/workspace/PLM2020/Intermediate/bmide_logs/MBD',
			lnxBuildSOOutput :  '/hd1a/home/tci01c03/sandbox/Linux_x86_64/lib',
			lnxLogPath :  'Logs',
			winLogPath :  'Logs',
		]
	]

	if (!releaseNodeMap.containsKey(release)) {
		println "Node map for ${release} not found!"
		return null
	}
	return releaseNodeMap[release]
}