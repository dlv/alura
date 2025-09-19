#!/bin/bash

# Este script instala o Docker e o Docker Compose em uma instância EC2
# com a imagem Amazon Linux, otimizado para a camada Free Tier.

# Define o nome do usuário que será adicionado ao grupo docker
# para que ele possa executar comandos docker sem usar sudo.
# O usuário 'ec2-user' é o padrão da imagem Amazon Linux.
USER_TO_ADD="ec2-user"

echo "Iniciando a instalação do Docker e do Docker Compose..."
echo "--------------------------------------------------------"

# 1. Atualizar o sistema
echo "Atualizando os pacotes do sistema..."
sudo yum update -y

# 2. Instalar o Docker
echo "Instalando o Docker..."
sudo yum install docker -y

# 3. Iniciar o serviço Docker
echo "Iniciando o serviço Docker..."
sudo systemctl start docker

# 4. Habilitar o Docker para iniciar com o sistema
echo "Habilitando o Docker para iniciar com o sistema..."
sudo systemctl enable docker

# 5. Adicionar o usuário 'ec2-user' ao grupo 'docker'
echo "Adicionando o usuário '$USER_TO_ADD' ao grupo 'docker'..."
sudo usermod -aG docker $USER_TO_ADD

# 6. Instalar o Docker Compose
echo "Instalando o Docker Compose..."
# Versão mais recente estável. Você pode verificar a versão mais recente em:
# https://github.com/docker/compose/releases
DOCKER_COMPOSE_VERSION="v2.21.0"
sudo curl -L "https://github.com/docker/compose/releases/download/$DOCKER_COMPOSE_VERSION/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

# 7. Conceder permissão de execução ao binário do Docker Compose
echo "Concedendo permissão de execução para o Docker Compose..."
sudo chmod +x /usr/local/bin/docker-compose

echo "--------------------------------------------------------"
echo "Instalação concluída!"
echo "Para que as alterações de grupo (adicionar o usuário '$USER_TO_ADD' ao grupo 'docker') entrem em vigor,"
echo "você precisará sair e entrar novamente na sessão SSH ou executar o comando: 'newgrp docker'"

echo "Verificando as versões instaladas..."
docker --version
docker-compose --version

echo "Script finalizado."