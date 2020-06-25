resource "aws_security_group" "allow_ssh" {
  vpc_id = aws_vpc.main.id
  name = "jordan_allow_ssh"

  ingress {
    from_port = 22
    protocol = "tcp"
    to_port = 22
    cidr_blocks = [var.my_public_ip]
  }
}

resource "aws_security_group" "database" {
  vpc_id = aws_vpc.main.id
  name = "jordan_database"

  ingress {
    from_port = 5432
    protocol = "tcp"
    to_port = 5432
    self = true
  }
}