/**
 * Returns the pwd() without any @ symbols in the path.
 * Note: You can only use this if you know that the node can use the base workspace
 */
def call() {
	def workDir = pwd();	
	return workDir
}
