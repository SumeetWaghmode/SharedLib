def call(config)
{	
	def workDir = sanePwd()

	def emailNotifications = 'sumeet.waghmode@intelizign.com'
	
	echo workDir

	dir(workDir) 
	{
		
		def subjectContents='Building Maven Project'
		

		if (currentBuild.currentResult == 'SUCCESS')
		{
			echo 'Current Build is SUCCESSFul'
			emailext attachLog: true, body: '\'\'\'Build Failed. we are testing the email configuration for failure cases!! </BR></BR>This will be updated with more details soon. </BR></BR>*********** Please DO NOT reply to this email ***********\'\'\'', subject: 'AutoBuild', to: 'sumeet.waghmode@intelizign.com'
			ansiColor('xterm') {
				println "\033[1;32m Current Build Result:: ${currentBuild.currentResult} \033[0m"
			}/*
			emailext body: '''${SCRIPT, template="groovy-html.template"}''',
			mimeType: 'text/html',
			subject: 'Build Success:'+subjectContents,
			to: emailNotifications,
			//replyTo: emailNotifications,*/
			//attachLog: true,
			//compressLog: true,
		}
		/*else if ((currentBuild.currentResult == 'FAILURE'))
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
		}*/
	}
}