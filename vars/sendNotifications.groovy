def call(config)
{	
	def workDir = sanePwd()

	def emailNotifications = 'sumeet.waghmode@intelizign.com'
	
	echo workDir

	dir(workDir) {
		
		def subjectContents='Project-PLM2020 Branch-'+"${env.BRANCH_NAME}"+' Build Components-'+"${params.component_to_build}"+' '+"${currentBuild.displayName}"
		
		sh"""export LANG=en_US.utf8
		rm -rfv Logs
		rm -fv logs.zip"""
		
		logStashes = ['winJarsLog',
		'winServerDllsLog',
		'winBmideDllsLog',
		'winBmidePackageLog',
		'lnxServerSosLog',
		'lnxBmideSosLog',
		'lnxExecsLogs']
		for (stashName in logStashes) {
			try {
				unstash(stashName)
			}
			catch (Exception e) {
			}
		}
		
			try {
					sh"""export LANG=en_US.utf8
		zip -r logs.zip Logs"""
			}
			catch (Exception e) {
			}
	
		
		if (currentBuild.currentResult == 'SUCCESS')
		{
			ansiColor('xterm') {
				println "\033[1;32m Current Build Result:: ${currentBuild.currentResult} \033[0m"
			}
			emailext body: '''${SCRIPT, template="groovy-html.template"}''',
			mimeType: 'text/html',
			subject: 'Build Success:'+subjectContents,
			to: emailNotifications,
			replyTo: emailNotifications,
			attachLog: true,
			compressLog: true,
			attachmentsPattern:'logs.zip'
			//attachmentsPattern:'/Logs/**/*.log'

		}
		else if ((currentBuild.currentResult == 'FAILURE'))
		{
			ansiColor('xterm') {
				println "\033[1;31m Current Build Result:: ${currentBuild.currentResult} \033[0m"
			}
			emailext body: '''${SCRIPT, template="groovy-html.template"}''',
			mimeType: 'text/html',
			subject: 'Build Failure:'+subjectContents,
			to: emailNotifications,
			replyTo: emailNotifications,
			attachLog: true,
			compressLog: true,
			attachmentsPattern:'logs.zip'
		}
		else if ((currentBuild.currentResult == 'UNSTABLE'))
		{
			ansiColor('xterm') {
				println "\033[1;33m Current Build Result:: ${currentBuild.currentResult} \033[0m"
			}
			emailext body: '''${SCRIPT, template="groovy-html.template"}''',
			mimeType: 'text/html',
			subject: 'Build Unstable:'+subjectContents,
			to: emailNotifications,
			replyTo: emailNotifications,
			attachLog: true,
			compressLog: true,
			attachmentsPattern:'logs.zip'
		}
	}
}