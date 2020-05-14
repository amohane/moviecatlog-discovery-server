node {
   def mvnHome
   def dockerHome
   def dockerImage
   stage('GIT checkout') {
   checkout([$class: 'GitSCM', 
   	branches: [[name: "${tag_branch}"]], 
   	browser: [$class: 'GithubWeb', 
   	repoUrl: 'https://github.com/amohane/moviecatlog-discovery-server'], 
   	doGenerateSubmoduleConfigurations: false, 
   	extensions: [], 
   	submoduleCfg: [], 
   	userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/amohane/moviecatlog-discovery-server.git']]])
   
	  //git branch: 'master', credentialsId: 'github', url: 'https://github.com/amohane/moviecatlog-discovery-server.git'      
	  // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool name: 'maven3', type: 'maven'
      dockerHome = tool name: 'Docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
   }
   stage('Build Maven') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
         if (isUnix()) {
            sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
         } else {
            bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
         }
      }
   }
   stage('Build Docker Image'){
      dockerImage=docker.build("amohane/moviecatlog-discovery-server:$tag_branch")
   }
   stage('Push Docker Image'){
      dockerImage.push("$tag_branch")
   }
}
