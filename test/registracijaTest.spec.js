describe('registracija uporabnika', function () {
    it('Obisk strani za registracijo in registracija', function () {
        cy.visit('http://localhost:4200/signup')

        cy.url()
            .should('include', '/signup')

        cy.get('.name')
            .type('Metka')
            .should('have.value', 'Metka')

        cy.get('.lastname')
            .type('Novak')
            .should('have.value', 'Novak')

        cy.get('.username')
            .type('metkanovak')
            .should('have.value', 'metkanovak')

        cy.get('.email')
            .type('metkanovak@gmail.com')
            .should('have.value', 'metkanovak@gmail.com')

        cy.get('.password1')
            .type('metkametka')
            .should('have.value', 'metkametka')

        cy.get('.password2')
            .type('metkametka')
            .should('have.value', 'metkametka')

        cy.get('[type="radio"]').check('lastnik')

        cy.get('.btn-primary')
            .click()



        cy.contains('Prijava')
    });
});
