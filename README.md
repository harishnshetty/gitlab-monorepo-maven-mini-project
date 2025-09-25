# Maven Spring-boot Monorepo Mini Project + Self-Host Runner Via Shell 

## Self Build Project

## For more projects, check out  
[https://harishnshetty.github.io/projects.html](https://harishnshetty.github.io/projects.html)

[![Video Tutorial](https://github.com/harishnshetty/image-data-project/blob/697a14a6f3bca7222218317e87d705e3fbe04f31/monorepo-java.jpg)](https://youtu.be/M6BxKpSvWa4)



## Ports to Enable in Security Group

| Service         | Port  |
|-----------------|-------|
| HTTP            | 80    |
| HTTPS           | 443   |
| SSH             | 22    |
| service-a       | 8080  |
| service-b       | 8081  |
| SonarQube       | 9000  |



# Prerequisites

This guide assumes an Ubuntu/Debian-like environment and sudo privileges.

## Create the Ec2-instance    

# c5d.large  2 Cpu 4 Mem
---

## System Update & Common Packages

```bash
sudo apt update
sudo apt upgrade -y

# Common tools
sudo apt install -y bash-completion wget git zip unzip curl jq net-tools build-essential ca-certificates apt-transport-https gnupg fontconfig
```
Reload bash completion if needed:
```bash
source /etc/bash_completion
```

**Install latest Git:**
```bash
sudo add-apt-repository ppa:git-core/ppa
sudo apt update
sudo apt install git -y
```
```bash
sudo apt-get update
sudo apt-get install -y openssl
```
## Java

Install OpenJDK (choose 17 or 21 depending on your needs):

```bash
# OpenJDK 17
sudo apt install -y openjdk-17-jdk

# OR OpenJDK 21
sudo apt install -y openjdk-21-jdk
```
Verify:
```bash
java --version
```
---

## Docker

Official docs: https://docs.docker.com/engine/install/ubuntu/

```bash
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update

sudo apt-get install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

# Add user to docker group (log out / in or newgrp to apply)
sudo usermod -aG docker $USER
newgrp docker
docker ps
```

Check Docker status:
```bash
sudo systemctl status docker
```

---

## Trivy (Vulnerability Scanner)

Docs: https://trivy.dev/v0.65/getting-started/installation/

```bash
sudo apt-get install wget apt-transport-https gnupg lsb-release
wget -qO - https://aquasecurity.github.io/trivy-repo/deb/public.key | sudo apt-key add -
echo deb https://aquasecurity.github.io/trivy-repo/deb $(lsb_release -sc) main | sudo tee -a /etc/apt/sources.list.d/trivy.list
sudo apt-get update
sudo apt-get install -y trivy


trivy --version
```

---
## SonarQube Docker Container Run for Analysis

```bash
docker run -d --name sonarqube \
  -p 9000:9000 \
  -v sonarqube_data:/opt/sonarqube/data \
  -v sonarqube_logs:/opt/sonarqube/logs \
  -v sonarqube_extensions:/opt/sonarqube/extensions \
  sonarqube:lts-community
```

```bash
sudo apt install maven
```

---

## Now add the Variables in the Gitlab

- DOCKER_USERNAME 
- DOCKER_PASSWORD 

- SONAR_TOKEN
- SONAR_HOST_URL

- EMAIL_USER 
- EMAIL_PASS  

---

## insatall Gitlab Runner in Your Ubuntu Machine (follow the officail website instrctiion steps)

```bash 
# Download the binary for your system
sudo curl -L --output /usr/local/bin/gitlab-runner https://gitlab-runner-downloads.s3.amazonaws.com/latest/binaries/gitlab-runner-linux-amd64

# Give it permission to execute
sudo chmod +x /usr/local/bin/gitlab-runner

# Create a GitLab Runner user
sudo useradd --comment 'GitLab Runner' --create-home gitlab-runner --shell /bin/bash

# Install and run as a service
sudo gitlab-runner install --user=gitlab-runner --working-directory=/home/gitlab-runner
sudo gitlab-runner start

# If using a `deb` package based distribution
curl -s https://packages.gitlab.com/install/repositories/runner/gitlab-runner/script.deb.sh | sudo bash
apt install -y gitlab-runner

# # If using an `rpm` package based distribution
# curl -s https://packages.gitlab.com/install/repositories/runner/gitlab-runner/script.rpm.sh | sudo bash
# dnf install -y gitlab-runner

```
---

```bash
java-runner1
```

---
## comment out all the Commands if the fail to Exectute the command
```bash
sudo nano /home/gitlab-runner/.bash_logout
```

```bash
sudo gitlab-runner status
```
---


---

If Git-labrunner needs Docker access:
```bash
sudo usermod -aG docker gitlab-runner
newgrp docker
sudo systemctl restart gitlab-runner
```


```bash
sudo usermod -aG trivy gitlab-runner
sudo systemctl restart gitlab-runner
```

# [Problem and Future Improvements needed]
- On Every Commit All MicroService Going to Rebuild the Docker images 
- (Solution)  We Can use the Diff method only changed Directory should trigger the Docker build and other Stages
---
- Docker images always uses the Docker latest tag and push to the Docker hub
- (Solution) the Docker Images tag we can use Git commit Ids for new Docker images

---
The Above Two Feature are not Improved in this Project

🔗 Stay Connected:
🌐 Website: https://harishnshetty.github.io/
💼 LinkedIn:   / harishnshetty  
🐱 GitHub: https://github.com/harishnshetty
