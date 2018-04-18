/**
 * Returns the pwd() without any @ symbols in the path.
 * Note: You can only use this if you know that the node can use the base workspace
 */
def call() {
	def workDir = cd()
	if (workDir.contains('@')) {
		return workDir.substring(0, workDir.indexOf('@'))
	}
	return workDir
}
