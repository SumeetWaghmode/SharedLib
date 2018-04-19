def call() {
	//echo workspace
	 {
		if (isUnix()) {
			vcsResult = checkout changelog: false, poll: false,
			scm: [$class                           : 'GitSCM',
				branches                         : [[name: refspec]],
				doGenerateSubmoduleConfigurations: false,
				extensions                       : [
					[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [
							[path: '/bmide'],
							[path: '/plm2020_auto_build/windows'],
							[path: '/server_customization/src']
						]]],
				submoduleCfg                     : [],
				userRemoteConfigs                : [[url: repoURL]]
			]

			// Clean old tmp files
			def gitPath = tool('Git')
			sh "${gitPath} clean -fd -e '**/history.xml' -e '**/obj' -e '**/lnx'"

			// Write the commit hash for the package build
			writeFile file: 'gitCommitHash.txt', text: "${vcsResult['GIT_COMMIT']}"
			archiveArtifacts artifacts: 'gitCommitHash.txt', fingerprint: true
			stash name: "lnxGitCommithash", includes: "gitCommitHash.txt"

		} else {
			// Is windows

			vcsResult = checkout changelog: false, poll: false,
			scm: [$class                           : 'GitSCM',
				branches                         : [[name: '*/master']],
				doGenerateSubmoduleConfigurations: false,
				extensions                       : [],
				submoduleCfg                     : [],
				userRemoteConfigs                : [[credentialsId: '5b9ca0cf-ce16-445b-96d7-1fa7466ce7b1', url: 'https://github.com/SumeetWaghmode/ExportXLSservice.git']]
			]

			writeFile file: 'gitCommitHash.txt', text: "${vcsResult['GIT_COMMIT']}"
			/*archiveArtifacts artifacts: 'gitCommitHash.txt', fingerprint: true
			stash name: "winGitCommithash", includes: "gitCommitHash.txt" */
		}

	}
}

return this