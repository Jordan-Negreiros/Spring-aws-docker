resource "aws_security_group" "allow_ssh" {
  vpc_id = aws_vpc.main.id
  name = "jordan_allow_ssh"

  ingress {
    from_port = 22
    protocol = "tcp"
    to_port = 22
    cidr_blocks = ["191.47.62.177/32"]
  }
}