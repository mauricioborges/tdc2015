# Ansible: infra as code

## Agenda

* O que é o Ansible?
* Arquitetura e conceitos do Ansible
* Um exemplo
* Next steps

## O que é o Ansible?

Ansible is a radically simple IT automation engine that automates cloud provisioning, configuration management, application deployment, intra-service orchestration, and many other IT needs.

* é uma ferramenta de provisionamento
* é um executor de comandos remotos ad hoc


## Arquitetura e conceitos do Ansible

### Python, SSH: seus amigos de todas as horas

* agentless
* python? você quis dizer praticamente toda distribuição *nix tem isso instalado?

### Inventory

* simples arquivo de texto contendo suas máquinas
* plugins para EC2

Exemplo:
```
[webservers]
www1.example.com
www2.example.com

[dbservers]
db0.example.com
db1.example.com
```

### Ad hoc commander

```
ansible all -m ping
ansible foo.example.com -m yum "name=httpd state=installed"
```

### Ansible Playbook!

* YAML
* roles

```
---
- hosts: webservers
- serial: 5 # update 5 machines at a time
- roles:
- - common
- - webapp
-
- - hosts: content_servers
- roles:
- - common
- - content
```

### Um exemplo
